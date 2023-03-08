package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Ticket;
import org.example.maximajavafinal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                + "{}"
                + "{}"
                + "{}");
    }

    @GetMapping("all_tickets")
    public List<Ticket> findAll () {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicket (@PathVariable Long id) {
        return service.findById(id);
    }
}
