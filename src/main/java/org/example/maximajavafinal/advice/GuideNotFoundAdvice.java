package org.example.maximajavafinal.advice;

import org.example.maximajavafinal.exception.GuideNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GuideNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler (GuideNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String GuideNotFoundHandler (GuideNotFoundException exception) {
        return exception.getMessage();
    }
}
