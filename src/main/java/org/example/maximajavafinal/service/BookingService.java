package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private GuideService guideService;

    @Autowired
    ExcursionService excursionService;

    @Autowired
    TicketService ticketService;

    @Autowired
    CustomerService customerService;

    public void signUp (Customer customer, Excursion excursion, int quantity) {
        if (excursion.getCapacity() > quantity) {
            while (quantity>0) {
                ticketService.save(new Ticket(excursion,customer));
                quantity--;
            }
        }

    }
}
