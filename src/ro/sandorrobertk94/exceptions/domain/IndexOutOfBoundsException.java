package ro.sandorrobertk94.exceptions.domain;

/**
 * Created by robert on 12/6/15.
 */
public class IndexOutOfBoundsException extends DomainException {
    public IndexOutOfBoundsException() {
        super();
    }

    public IndexOutOfBoundsException(String message) {
        super(message);
    }

    public IndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    protected IndexOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
