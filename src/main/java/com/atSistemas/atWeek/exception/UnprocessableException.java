package com.atSistemas.atWeek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableException extends RuntimeException{

    public UnprocessableException() {
        super();
    }

    public UnprocessableException(String message) {
        super(message);
    }
}
