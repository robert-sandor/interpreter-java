package ro.sandorrobertk94.exceptions.util;

/**
 * Created by robert on 11/20/15.
 */
public class ArrayOverflowException extends UtilException {
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
