package org.example.maximajavafinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    @GetMapping ("/hallo")
    public String auth (Principal principal) {
        return ("Hallo " + principal.getName() +"!");
    }
}
