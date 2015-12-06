package ro.sandorrobertk94.exceptions.domain;

/**
 * Created by robert on 12/6/15.
 */
public class ArrayOverflowException extends DomainException {
    public ArrayOverflowException() {
        super();
    }

    public ArrayOverflowException(String message) {
        super(message);
    }

    public ArrayOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayOverflowException(Throwable cause) {
        super(cause);
    }

    protected ArrayOverflowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
