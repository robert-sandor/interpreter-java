package ro.sandorrobertk94.exceptions.domain;

import ro.sandorrobertk94.exceptions.repository.RepositoryException;

/**
 * Created by robert on 12/6/15.
 */
public abstract class DomainException extends RepositoryException {
    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }

    protected DomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
