package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Ticket> ticketList = ticketService.findTicketsByCustomerAndExcursion(customer, excursion);
        ticketList.forEach(System.out::println);
        int availableTicketsQuantity = ticketList.size();
        long ticketId = ticketList.get(0).getId();
        while (quantity>0 && availableTicketsQuantity>0) {
            ticketService.deleteById(ticketId);
            quantity--;
            availableTicketsQuantity--;
            ticketId++;
        }
    }
}
