package by.epam.kvirikashvili.task1_2.exception;

public class NoSuchComparatorTypeException extends Exception {
    public NoSuchComparatorTypeException() {
    }

    public NoSuchComparatorTypeException(String message) {
        super(message);
    }

    public NoSuchComparatorTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchComparatorTypeException(Throwable cause) {
        super(cause);
    }

    public NoSuchComparatorTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
