package org.example.maximajavafinal.exeptions;

import java.util.NoSuchElementException;

public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(String message) {super("Not found object with " + message);}
}
