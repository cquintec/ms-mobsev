package com.mobdev.ms.exceptions;

import lombok.Getter;

@Getter
public class ApiClientException extends Exception{

    private final int internalCode;
    public ApiClientException(String message, int internalCode) {
        super(message);
        this.internalCode = internalCode;
    }

    public ApiClientException(String message, Throwable cause, int internalCode) {
        super(message, cause);
        this.internalCode = internalCode;
    }
}
