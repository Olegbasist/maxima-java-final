package org.example.maximajavafinal.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message) {
        super("Customer with id={" + message + "} not found");
    }
}
