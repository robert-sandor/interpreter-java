package ro.sandorrobertk94.exceptions.domain;

/**
 * Created by robert on 12/6/15.
 */
public class DivisionByZeroException extends DomainException {
    public DivisionByZeroException() {
        super();
    }

    public DivisionByZeroException(String message) {
        super(message);
    }

    public DivisionByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivisionByZeroException(Throwable cause) {
        super(cause);
    }

    protected DivisionByZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
