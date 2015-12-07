package ro.sandorrobertk94.exceptions.repository;

/**
 * Created by robert on 12/7/15.
 */
public class SavingToFileException extends RepositoryException {
    public SavingToFileException() {
        super();
    }

    public SavingToFileException(String message) {
        super(message);
    }

    public SavingToFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public SavingToFileException(Throwable cause) {
        super(cause);
    }

    protected SavingToFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
