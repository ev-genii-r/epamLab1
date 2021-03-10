package com.epam.lab1.myExceptions;

public class dataInputException extends Exception {
    public dataInputException() {
    }

    public dataInputException(String message) {
        super(message);
    }

    public dataInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public dataInputException(Throwable cause) {
        super(cause);
    }

    public dataInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
