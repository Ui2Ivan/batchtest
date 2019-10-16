package jp.co.u_idea2.batch.common.listener;

import jp.co.u_idea2.batch.common.logging.LogMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobLoggingListener implements JobExecutionListener {

    /**
     * メッセージ出力に利用するログ機能を提供するインタフェース。
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JobLoggingListener.class);

    /**
     * ジョブ開始前処理。
     * 
     * @param jobExecution
     */
    @Override
    public void beforeJob(JobExecution jobExecution) {
        // ジョブが開始したことをログに出力する。
        LOGGER.info(LogMessages.I_AR_common_L0001.getMessage(jobExecution.getJobInstance().getJobName()));
    }

    /**
     * ジョブ終了後処理。
     * 
     * @param jobExecution
     */
    @Override
    public void afterJob(JobExecution jobExecution) {
        // ジョブが終了したことをログに出力する。
        LOGGER.info(LogMessages.I_AR_common_L0002.getMessage(jobExecution.getJobInstance().getJobName()));
    }

}
