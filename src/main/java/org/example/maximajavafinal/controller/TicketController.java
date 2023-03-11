package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Ticket;
import org.example.maximajavafinal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "[\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/ticket\",\n" +
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
                "          \"url\": \"http://localhost:8080/ticket/all_tickets\",\n" +
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
                "          \"url\": \"http://localhost:8080/ticket/1\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"\",\n" +
                "              \"value\": \"\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {}\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/ticket/new\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"application/x-www-form-urlencoded\",\n" +
                "            \"params\": [\n" +
                "              {\n" +
                "                \"name\": \"price\",\n" +
                "                \"value\": \"100\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"price=100\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"DELETE\",\n" +
                "          \"url\": \"http://localhost:8080/ticket/delete/1\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"\",\n" +
                "            \"params\": [],\n" +
                "            \"text\": \"confirm=DELETE\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"DELETE\",\n" +
                "          \"url\": \"http://localhost:8080/ticket/delete/all\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"application/x-www-form-urlencoded\",\n" +
                "            \"params\": [\n" +
                "              {\n" +
                "                \"name\": \"confirm\",\n" +
                "                \"value\": \"DELETE\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"confirm=DELETE\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]"
                );
    }

    @GetMapping("all_tickets")
    public List<Ticket> findAll () {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket (@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Ticket> addGuide (@RequestBody Ticket ticket) {
        service.save(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTicket (@PathVariable Long id) {
        service.deleteById(id);}

    @DeleteMapping("/delete/all")
    public void deleteAllTickets (@RequestBody String confirm) {
        if (Objects.equals(confirm, "{\"confirm\":\"DELETE\"}")){
            service.deleteAll();}
    }
}
