package com.mobdev.ms.controller;

import com.mobdev.ms.dtos.ErrorResponseDto;
import com.mobdev.ms.enums.ErrorEnums;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.exceptions.CharacterMapperException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ApiClientException.class, HttpClientErrorException.class})
    public ResponseEntity<ErrorResponseDto> handleApiRestExceptions(ApiClientException apiClientException){
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .codigo(apiClientException.getInternalCode())
                .timeStamp(LocalDateTime.now())
                .detail(apiClientException.getMessage())
                .build();
        return new ResponseEntity<>(errorResponseDto, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseDto> resourceNotFoundException(
            MissingServletRequestParameterException ex, WebRequest request) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .codigo(ErrorEnums.RQ_PARAMETER_MISSING.getCode())
                .timeStamp(LocalDateTime.now())
                .detail(ErrorEnums.RQ_PARAMETER_MISSING.getMessage())
                .build();

        return new ResponseEntity<>(errorResponseDto, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto> methodArgumentMismatchException(
            MethodArgumentTypeMismatchException ex) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .codigo(ErrorEnums.BAD_TYPE_PARAMETER.getCode())
                .timeStamp(LocalDateTime.now())
                .detail(ErrorEnums.BAD_TYPE_PARAMETER.getMessage()+ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponseDto, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CharacterMapperException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDto> characterMapperException(
            CharacterMapperException ex) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .codigo(ErrorEnums.CHARACTER_MAPPER_ERROR.getCode())
                .timeStamp(LocalDateTime.now())
                .detail(ErrorEnums.CHARACTER_MAPPER_ERROR.getMessage()+ex.getMessage())
                .build();

        return new ResponseEntity<>(errorResponseDto, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
