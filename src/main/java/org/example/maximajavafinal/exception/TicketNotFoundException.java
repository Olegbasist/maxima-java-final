package org.example.maximajavafinal.exception;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(String message) {
        super("Ticket with id ={" + message + "} not found");
    }
}
