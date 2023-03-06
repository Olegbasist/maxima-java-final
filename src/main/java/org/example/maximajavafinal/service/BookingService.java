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
            int counter = 0;
            while (quantity>0) {
                ticketService.save(new Ticket(excursion,customer));
                quantity--;
                counter ++;
            }
            System.out.println("Customer " + customer.getName() +
                    " successfully signed on '" + excursion.getTitle() +
                    "' at " + excursion.getDate() +
                    " with " + counter + " tickets" );
        }else {
            System.out.println("Not enough free tickets (" + quantity + "). Try to request less, or enlarge excursion capacity.");
        }


    }
    public void signOut (Customer customer, Excursion excursion, int quantity) {
        System.out.println("Not available for now. Query under construction.");
    }
}
