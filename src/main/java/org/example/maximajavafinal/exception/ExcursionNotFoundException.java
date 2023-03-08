package org.example.maximajavafinal.exception;

public class ExcursionNotFoundException extends RuntimeException{
    public ExcursionNotFoundException(String message) {
        super("Excursion with id={" + message + "} not found");
    }
}
