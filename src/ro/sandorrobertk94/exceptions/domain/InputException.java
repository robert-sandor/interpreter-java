package ro.sandorrobertk94.exceptions.domain;

/**
 * Created by robert on 12/6/15.
 */
public class InputException extends DomainException {
    public InputException() {
        super();
    }

    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputException(Throwable cause) {
        super(cause);
    }

    protected InputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
