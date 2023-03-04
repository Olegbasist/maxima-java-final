package org.example.maximajavafinal.advice;

import org.example.maximajavafinal.exeptions.NotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundAdvice (NotFoundExeption exeption) {
        return exeption.getMessage();
    }

}
