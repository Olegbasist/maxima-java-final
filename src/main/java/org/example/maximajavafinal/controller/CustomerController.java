package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String root () {
        return ("Available requests:"
                +"{all_customers}"
                +"{}"
                +"{}"
                +"{}"
                +"{}");
    }

    @GetMapping ("/all_customers")
    public List<Customer> findAllCustomers () {
        return customerService.findAll();
    }
}
