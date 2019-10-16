package jp.co.u_idea2.batch.common.util;

import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.u_idea2.batch.common.logging.LogMessages;

import java.util.Date;

/**
 * 日付変換に関するユーティリティクラス。
 * 
 * @author 電電 次郎
 */
public class DateUtil {
    /**
     * メッセージ出力に利用するログ機能を提供するインタフェース。
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    /**
     * コンストラクタ
     */
    private DateUtil() {
        // do nothing.
    }

    /**
     * 日付文字列をDate型に変換する。
     * 
     * @param dateStr 日付文字列(yyyyMMdd)
     * @return 日付文字列をDate型に変換した結果
     * @throws IllegalArgumentException 日付変換エラー
     */
    public static Date convertDate(String dateStr) throws IllegalArgumentException {
        try {
            return DateTimeFormat.forPattern("yyyyMMdd").parseDateTime(dateStr).toDate();
        } catch (IllegalArgumentException e) {
            // 日付変換エラー
            LOGGER.error(LogMessages.E_AR_common_L9002.getMessage(dateStr), e);
            throw e;
        }
    }
}
