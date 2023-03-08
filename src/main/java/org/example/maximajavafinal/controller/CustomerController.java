package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ("Available requests: "
                + "GET:{all_customers}, "
                + "GET:{id}, "
                + "POST: {/new}, Content-Type={application/json}, RequestBody={name=name}}, "
        );
    }

    @GetMapping ("/all_customers")
    public List<Customer> findAllCustomers () {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Customer getTicket (@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> addGuide (@RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
