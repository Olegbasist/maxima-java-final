package org.example.maximajavafinal.service;
import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.model.Excursion;
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
    public void makeTickets (int quantity, int price, Excursion excursion){
        while (quantity>0){
            save(new Ticket(price,excursion));
            quantity--;
        }
    }

    public List<Ticket> findAll () {
        return repository.findAll();
    }

    public Ticket findById (Long id) {return repository.findById(id).isPresent() ? repository.findById(id).get() : null;}



    public void deleteById (Long id) {repository.deleteById(id);}

}
