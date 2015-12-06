package ro.sandorrobertk94.exceptions.view;

import ro.sandorrobertk94.exceptions.InterpreterException;

/**
 * Created by robert on 12/6/15.
 */
public abstract class ViewException extends InterpreterException {
    public ViewException() {
        super();
    }

    public ViewException(String message) {
        super(message);
    }

    public ViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViewException(Throwable cause) {
        super(cause);
    }

    protected ViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
