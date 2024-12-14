package org.dev.xoobackend.exception;

public class allExceptiosHandle extends RuntimeException{
    public allExceptiosHandle(Throwable cause) {
        super(cause);
    }

    public allExceptiosHandle(String message, Throwable cause) {
        super(message, cause);
    }

    public allExceptiosHandle(String message) {
        super(message);
    }
}
