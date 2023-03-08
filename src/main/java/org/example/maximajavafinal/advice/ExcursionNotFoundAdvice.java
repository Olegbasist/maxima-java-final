package org.example.maximajavafinal.advice;

import org.example.maximajavafinal.exception.ExcursionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExcursionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler (ExcursionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ExcursionNotFoundHandler (ExcursionNotFoundException exception) {
        return exception.getMessage();
    }
}
