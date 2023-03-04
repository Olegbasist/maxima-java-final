package org.example.maximajavafinal.exeptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {super("Not found object with " + message);}
}
