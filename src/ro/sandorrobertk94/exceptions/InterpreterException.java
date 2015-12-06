package ro.sandorrobertk94.exceptions;

/**
 * Created by robert on 12/6/15.
 */
public abstract class InterpreterException extends Exception {
    public InterpreterException() {
        super();
    }

    public InterpreterException(String message) {
        super(message);
    }

    public InterpreterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterpreterException(Throwable cause) {
        super(cause);
    }

    protected InterpreterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
