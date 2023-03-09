package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Mediator;
import org.example.maximajavafinal.service.BookingService;
import org.example.maximajavafinal.service.CustomerService;
import org.example.maximajavafinal.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ExcursionService excursionService;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "POST: {/signup}, Content-Type={application/json}, RequestBody={customer_id=id}, {excursion_id=id}, {quantity=int}}, "
                + "POST: {/signout}, Content-Type={application/json}, RequestBody={customer_id=id}, {excursion_id=id}, {quantity=int}}, "
        );
    }

    @PostMapping("/signup")
    public void signUpCustomerForExcursion (@RequestBody Mediator mediator) {
        Customer customer = customerService.findById(mediator.getCustomer_id());
        Excursion excursion = excursionService.findById(mediator.getExcursion_id());
        int quantity = mediator.getQuantity();
        bookingService.signUp(customer, excursion, quantity);
    }
    @PostMapping("/signout")
    public void signOutCustomerForExcursion (@RequestBody Mediator mediator) {
        Customer customer = customerService.findById(mediator.getCustomer_id());
        Excursion excursion = excursionService.findById(mediator.getExcursion_id());
        int quantity = mediator.getQuantity();
        bookingService.signOut(customer, excursion, quantity);
    }
}
