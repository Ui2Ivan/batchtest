package jp.co.u_idea2.batch.common.exception;

/**
 * U_idea2-Batch用のExceptionクラス。
 * 
 * @author Ui2 太郎太郎太郎太郎
 */
public class U_idea2BatchException extends BatchException {

    /**
     * シリアルバージョンID
     */
    private static final long serialVersionUID = 6368315692983549460L;

    /**
     * u_idea2BatchExceptionを生成する
     */
    public U_idea2BatchException() {
        super();
    }

    /**
     * u_idea2BatchExceptionを生成する
     * 
     * @param message エラーメッセージ
     */
    public U_idea2BatchException(String message) {
        super(message);
    }

    /**
     * u_idea2BatchExceptionを生成する
     * 
     * @param message エラーメッセージ
     * @param cause 原因となった例外
     */
    public U_idea2BatchException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * u_idea2BatchExceptionを生成する
     * 
     * @param cause 原因となった例外
     */
    public U_idea2BatchException(Throwable cause) {
        super(cause);
    }
}
