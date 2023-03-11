package org.example.maximajavafinal.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RootController {


    @GetMapping
    public String root () {
        return ("Available requests: "
                + "[\n" +
                "{\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/booking\",\n" +
                "        }\n" +
                "}\n" +
                "{\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/customer\",\n" +
                "        }\n" +
                "}\n" +
                "{\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/excursion\",\n" +
                "        }\n" +
                "}\n" +
                "{\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/guide\",\n" +
                "        }\n" +
                "}\n" +
                "{\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/ticket\",\n" +
                "        }\n" +
                "}\n" +
                "]"
        );
    }
}
