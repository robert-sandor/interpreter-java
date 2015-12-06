package ro.sandorrobertk94.exceptions.repository;

import ro.sandorrobertk94.exceptions.controller.ControllerException;

/**
 * Created by robert on 12/6/15.
 */
public abstract class RepositoryException extends ControllerException {
    public RepositoryException() {
        super();
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    protected RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
