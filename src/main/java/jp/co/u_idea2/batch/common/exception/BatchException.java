package jp.co.u_idea2.batch.common.exception;

public class BatchException extends RuntimeException {

    /**
     * シリアルバージョンID
     */
    private static final long serialVersionUID = -3410319869928153997L;

    public BatchException() {
    }

    public BatchException(String message) {
        super(message);
    }

    public BatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatchException(Throwable cause) {
        super(cause);
    }
}
