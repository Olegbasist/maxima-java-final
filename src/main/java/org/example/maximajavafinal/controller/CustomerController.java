package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public String root () {
        return ("Available requests:"
                +"GET:{all_customers}, "
                +"GET:{id}, "
                +"{}"
                +"{}"
                +"{}");
    }

    @GetMapping ("/all_customers")
    public List<Customer> findAllCustomers () {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Customer getTicket (@PathVariable Long id) {
        return service.findById(id);
    }
}
