package org.example.maximajavafinal.exeptions;

public class NotFoundExeption extends NullPointerException{
    public NotFoundExeption(String message) {super("Not found " + message);}
}
