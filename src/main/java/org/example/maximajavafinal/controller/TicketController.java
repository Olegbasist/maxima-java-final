package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Ticket;
import org.example.maximajavafinal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "GET:{all_tickets}, "
                + "{}"
                + "{}"
                + "{}"
                + "{}");
    }

    @GetMapping("all_tickets")
    public List<Ticket> findAll () {
        return ticketService.findAll();
    }
}
