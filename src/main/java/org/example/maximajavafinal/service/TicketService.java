package org.example.maximajavafinal.service;
import org.example.maximajavafinal.model.Ticket;
import org.example.maximajavafinal.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository repository;

    public void save (Ticket ticket) {repository.save(ticket);}

    @Transactional(readOnly = true)
    public List<Ticket> findAll () {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Ticket findById (Long id) {return repository.findById(id).isPresent() ? repository.findById(id).get() : null;}

    public void deleteById (Long id) {repository.deleteById(id);}

    public void deleteAll () {repository.deleteAll();}

}
