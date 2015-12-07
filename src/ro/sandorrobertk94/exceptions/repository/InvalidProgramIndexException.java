package ro.sandorrobertk94.exceptions.repository;

/**
 * Created by robert on 12/7/15.
 */
public class InvalidProgramIndexException extends RepositoryException {
    public InvalidProgramIndexException() {
        super();
    }

    public InvalidProgramIndexException(String message) {
        super(message);
    }

    public InvalidProgramIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProgramIndexException(Throwable cause) {
        super(cause);
    }

    protected InvalidProgramIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
