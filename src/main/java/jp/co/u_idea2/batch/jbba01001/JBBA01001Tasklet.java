package jp.co.u_idea2.batch.jbba01001;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.JsonObject;
import com.sendgrid.SendGrid;
import jp.co.u_idea2.batch.common.exception.U_idea2BatchException;
import jp.co.u_idea2.batch.common.logging.LogMessages;
import jp.co.u_idea2.batch.common.util.DateUtil;
import jp.co.u_idea2.batch.jbba00.FlightDto;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
/**
 * フライト情報更新ファイルを読込み、フライト情報を更新する。
 * 
 * @author NTT 電電太郎
 */
@Component("JBBA01001Tasklet")
@Scope("step")
public class JBBA01001Tasklet implements Tasklet {

    /**
     * メッセージ出力に利用するログ機能を提供するインタフェース。
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JBBA01001Tasklet.class);

    /**
     * 入力チェック用のバリデータ。
     */
    @Inject
    Validator<FlightUpdateDto> validator;

    /**
     * メッセージ管理機能。
     */
    @Inject
    MessageSource messageSource;

    /**
     * ファイルアクセス用（入力）インターフェース。
     */
    @Inject
    ItemStreamReader<FlightUpdateDto> flightUpdateReader;

    /**
     * フライト情報更新DAOインタフェース。
     */
    @Inject
    JBBA01001BatchDao dao;

    /**
     * Beanマッパー。
     */
    @Inject
    Mapper beanMapper;

    /**
     * フライト情報更新ファイルパス
     */
    @Value("${path.FlightUpdate}")
    private String PATH_FLIGHT_UPDATE;

    /**
     * フライト情報更新ファイル（リネーム後）パス
     */
    @Value("${path.RenameFlightUpdate}")
    private String PATH_RENAME_FLIGHT_UPDATE;

    /**
     * ユーザーの現在の作業ディレクトリ。
     */
    @Value("${user.dir}")
    private String userDir;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // 入出力ファイルのパスを取得
//        Path inputFile = Paths.get(userDir, PATH_FLIGHT_UPDATE);
//        Path outputFile = Paths.get(userDir, PATH_RENAME_FLIGHT_UPDATE);

        // フライト情報更新ファイルの存在チェックを実施する。
//        if (!Files.exists(inputFile)) {
//            // 更新ファイルの取得失敗（10:警告終了）
//            LOGGER.warn(LogMessages.W_AR_BA01_L8001.getMessage(inputFile.toString()));
//            contribution.setExitStatus(new ExitStatus("WARNING"));
//            return RepeatStatus.FINISHED;
//        }

        sendMailTemplate();
//        setVersion();
//        Email from = new Email("ivan@ui2.co.jp");
//        from.setName("Ivan");
//        String subject = "Hello World from the SendGrid Java Library!";
//        Email to = new Email("ivan@ui2.co.jp");
//        Email cc = new Email("fatho0@gmail.com");
//        Email bcc = new Email("fatho2@gmail.com");
//        Content content = new Content("text/plain", "Hello, Email!");
//        Mail mail = new Mail();
//        mail.setSubject(subject);
//        mail.setFrom(from);
//        mail.setReplyTo(from);
//        mail.addContent(content);
//        Personalization personalization = new Personalization();
//        personalization.addCc(cc);
//        personalization.addTo(to);
//        personalization.addBcc(bcc);
//        mail.addPersonalization(personalization);
//        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
//        Request request = new Request();
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            Response response = sg.api(request);
//            System.out.println(response.getStatusCode());
//            System.out.println(response.getBody());
//            System.out.println(response.getHeaders());
//        } catch (IOException ex) {
//            throw ex;
//        }
        // フライト情報登録件数
        int insertFlightCnt = 0;

        try {
            // フライト情報更新ファイルオープン
//            flightUpdateReader.open(chunkContext.getStepContext().getStepExecution().getExecutionContext());
//
//            // 入力先ファイルをログに出力
//            LOGGER.info(LogMessages.I_AR_common_L0004.getMessage(inputFile.toString()));
//
//            // 登録（入力チェック）処理
//            insertFlightCnt = registerData(flightUpdateReader);

        } catch (ItemStreamException e) {
            // ファイルオープンエラー
            LOGGER.error(LogMessages.E_AR_common_L9006.getMessage());
            throw new U_idea2BatchException(e);
        } finally {
            try {
                flightUpdateReader.close();
            } catch (ItemStreamException e) {
                // クローズ失敗
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("クローズ失敗", e);
                }
            }
        }

        try {
            // フライト情報更新ファイルのリネーム
//            Files.move(inputFile, outputFile);
        } catch (Exception e) {
            // ファイルリネーム失敗
//            LOGGER.error(LogMessages.E_AR_common_L9009.getMessage(inputFile.toString(), outputFile.toString()), e);
            throw new U_idea2BatchException(e);
        }

        // 登録件数をログに出力する。
        LOGGER.info(LogMessages.I_AR_BA01_L0001.getMessage(String.valueOf(insertFlightCnt)));

        // ジョブ終了コード（0:正常終了）
        contribution.setExitStatus(new ExitStatus("NORMAL"));

        return RepeatStatus.FINISHED;
    }

    private void sendMailTemplate() throws Exception{
        Email from = new Email("ivan@ui2.co.jp");
        from.setName("Ivan");
        String subject = "Hello World from the SendGrid Java Library!";
        Email to = new Email("ivan@ui2.co.jp");
        Email cc = new Email("fatho0@gmail.com");
        Email bcc = new Email("fatho2@gmail.com");
        Content content = new Content("text/plain", "Hello, Email!");
        Mail mail = new Mail();
        mail.setSubject(" ");
        mail.setFrom(from);
        mail.setReplyTo(from);
//        mail.setTemplateId("d-41698dc549a54b7b9f9867ece5c85685");
        mail.setTemplateId("33346b44-682e-461a-b615-999de8871b74");
        Personalization personalization = new Personalization();
//        personalization.addDynamicTemplateData("customername", "User1");
        personalization.addSubstitution("subject", "User1");
        personalization.addTo(to);
        mail.addPersonalization(personalization);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void setTemplate() throws Exception{
        try {
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("templates");
            request.setBody("{\"name\":\"example_name\"}");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void setVersion() throws Exception{
        try {
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("templates/33346b44-682e-461a-b615-999de8871b74/versions");
            request.setBody("{\"name\":\"example_version_name\",\"html_content\":\"Hello <%body%>\",\"plain_content\":\"Hello <%body%>\",\"active\":1,\"template_id\":\"ddb96bbc-9b92-425e-8979-99464621b543\",\"subject\":\"Hello <%subject%>\"}");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
/*

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class DynamicTemplatePersonalization extends Personalization {

        @JsonProperty("dynamic_template_data")
        private Map<String, Object> dynamicTemplateData = new HashMap<>();

        public void addDynamicTemplateData(String key, Object value) {
            dynamicTemplateData.put(key, value);
        }
    }*/
    private void sendMail() throws Exception{
        Email from = new Email("ivan@ui2.co.jp");
        from.setName("Ivan");
        String subject = "Hello World from the SendGrid Java Library!";
        Email to = new Email("ivan@ui2.co.jp");
        Email cc = new Email("fatho0@gmail.com");
        Email bcc = new Email("fatho2@gmail.com");
        Content content = new Content("text/plain", "Hello, Email!");
        Mail mail = new Mail();
        mail.setSubject(subject);
        mail.setFrom(from);
        mail.setReplyTo(from);
        mail.addContent(content);
        Personalization personalization = new Personalization();
        personalization.addCc(cc);
        personalization.addTo(to);
        personalization.addBcc(bcc);
        mail.addPersonalization(personalization);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
    /**
     * 登録（入力チェック）処理
     * 
     * @param reader 入力データ
     * @return フライト情報登録件数
     * @throws U_idea2BatchException
     */
    /*private int registerData(ItemStreamReader<FlightUpdateDto> reader) throws U_idea2BatchException {
        // フライト情報登録件数
        int insertFlightCnt = 0;

        try {
            // フライト情報更新ファイルからデータを取得して入力チェック
            FlightUpdateDto flightUpdateData = null;
            while ((flightUpdateData = reader.read()) != null) {
                // 入力チェックエラーハンドリング
                try {
                    validator.validate(flightUpdateData);
                } catch (ValidationException e) {
                    // FieldErrorsの個数分、以下の処理を繰り返す
                    for (FieldError fieldError : ((BindException) e.getCause()).getFieldErrors()) {
                        // 入力チェックエラーメッセージを出力
                        LOGGER.warn(messageSource.getMessage(fieldError, null) + "[" + fieldError.getRejectedValue()
                                + "]" + "(" + flightUpdateData.getCount() + ")");
                    }
                    
                    // 入力チェックエラー
                    LOGGER.error(LogMessages.E_AR_common_L9003.getMessage(), e);
                    throw new U_idea2BatchException(e);
                }

                // DTOの詰め替え処理
                FlightDto flightDto = beanMapper.map(flightUpdateData, FlightDto.class);

                try {
                    // 日付型変換
                    flightDto.setDepartureDate(DateUtil.convertDate(flightUpdateData.getDepartureDateStr()));

                    // 数値型変換
                    flightDto.setVacantNum(Integer.parseInt(flightUpdateData.getVacantNumStr()));

                } catch (IllegalArgumentException e) {
                    // 型変換エラー
                    LOGGER.error(LogMessages.E_AR_common_L9005.getMessage(), e);
                    throw new U_idea2BatchException(e);
                }

                // フライト情報を登録する
                try {
                    dao.insertFlight(flightDto);
                } catch (Exception e) {
                    // DB登録エラー
                    LOGGER.error(LogMessages.E_AR_common_L9008.getMessage());
                    throw new U_idea2BatchException(e);
                }

                insertFlightCnt++;
            }
        } catch (Exception e) {
            // 入力データ読込エラー
            LOGGER.error(LogMessages.E_AR_common_L9007.getMessage());
            throw new U_idea2BatchException(e);
        }

        return insertFlightCnt;
    }*/
}
