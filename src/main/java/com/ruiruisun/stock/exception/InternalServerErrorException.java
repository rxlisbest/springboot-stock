package com.ruiruisun.stock.exception;

public class InternalServerErrorException extends Exception {
    private String message;

    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
