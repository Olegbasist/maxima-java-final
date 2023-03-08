package org.example.maximajavafinal.exception;

public class GuideNotFoundException extends RuntimeException{
    public GuideNotFoundException(String message) {
        super("Guide with id={" + message + "} not found");
    }
}
