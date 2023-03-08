package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Ticket;
import org.example.maximajavafinal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "GET:{all_tickets}, "
                + "GET:{id}, "
                + "POST: {/new}, Content-Type={application/json}, RequestBody={price=price}}, ");
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
}
