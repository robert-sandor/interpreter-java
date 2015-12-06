package ro.sandorrobertk94.exceptions.controller;

import ro.sandorrobertk94.exceptions.view.ViewException;

/**
 * Created by robert on 12/6/15.
 */
public abstract class ControllerException extends ViewException {
    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    protected ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
