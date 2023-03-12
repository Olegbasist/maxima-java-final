package org.example.maximajavafinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    @GetMapping ("/hallo")
    public String hallo (Principal principal) {
        if (principal == null) {
            return "Available requests for anonymous user:" +
                    " [\n" +
                    "      {\n" +
                    "        \"request\": {\n" +
                    "          \"method\": \"GET\",\n" +
                    "          \"url\": \"http://localhost:8080/hallo\",\n" +
                    "          \"headers\": [\n" +
                    "            {\n" +
                    "              \"name\": \"\",\n" +
                    "              \"value\": \"\"\n" +
                    "            }\n" +
                    "          ],\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"request\": {\n" +
                    "          \"method\": \"GET\",\n" +
                    "          \"url\": \"http://localhost:8080/excursion/all_excursions\",\n" +
                    "          \"headers\": [\n" +
                    "            {\n" +
                    "              \"name\": \"\",\n" +
                    "              \"value\": \"\"\n" +
                    "            }\n" +
                    "          ],\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]";
        }else {
            return "Hallo " + principal.getName() + "!";
        }
    }
}
