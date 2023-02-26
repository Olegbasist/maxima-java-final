package org.example.maximajavafinal.service;
import org.example.maximajavafinal.model.Ticket;
import org.example.maximajavafinal.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository repository;

    public void save (Ticket ticket) {repository.save(ticket);}

    public List<Ticket> findAll () {
        return repository.findAll();
    }

    public Ticket findById (Long id) {return repository.findById(id).get();}


    public void deleteById (Long id) {repository.deleteById(id);}
}
