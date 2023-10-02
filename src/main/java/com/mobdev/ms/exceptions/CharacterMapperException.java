package com.mobdev.ms.exceptions;

import lombok.Getter;

@Getter
public class CharacterMapperException extends Exception{

    private final int internalCode;
    public CharacterMapperException(String message, int internalCode) {
        super(message);
        this.internalCode = internalCode;
    }

    public CharacterMapperException(String message, Throwable cause, int internalCode) {
        super(message, cause);
        this.internalCode = internalCode;
    }
}
