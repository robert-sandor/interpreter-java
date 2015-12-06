package ro.sandorrobertk94.exceptions.domain;

/**
 * Created by robert on 12/6/15.
 */
public class InvalidHeapAddressException extends DomainException {
    public InvalidHeapAddressException() {
        super();
    }

    public InvalidHeapAddressException(String message) {
        super(message);
    }

    public InvalidHeapAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidHeapAddressException(Throwable cause) {
        super(cause);
    }

    protected InvalidHeapAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
