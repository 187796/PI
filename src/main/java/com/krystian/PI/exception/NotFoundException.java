package com.krystian.PI.exception;

/**
 * Created by Krystian on 2016-10-17.
 */
public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = -6479537963838348219L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
