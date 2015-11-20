package ro.sandorrobertk94.exceptions.util;

import ro.sandorrobertk94.exceptions.InterpreterException;

/**
 * Created by robert on 11/20/15.
 */
public abstract class UtilException extends InterpreterException {
    public UtilException() {
        super();
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilException(Throwable cause) {
        super(cause);
    }

    protected UtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
