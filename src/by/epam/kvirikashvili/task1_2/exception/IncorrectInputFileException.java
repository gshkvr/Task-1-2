package by.epam.kvirikashvili.task1_2.exception;

public class IncorrectInputFileException extends Exception {
    public IncorrectInputFileException() {
    }

    public IncorrectInputFileException(String message) {
        super(message);
    }

    public IncorrectInputFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputFileException(Throwable cause) {
        super(cause);
    }

    public IncorrectInputFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
