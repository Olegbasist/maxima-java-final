package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
                + "GET: {/name/{string}}, "
                + "POST: {/new}, Content-Type={application/json}, RequestBody={name=name}}, "
                + "DELETE: {/delete/{id}}, "
                + "DELETE: {/delete/all}, Content-Type={application/json}, RequestBody={confirm=DELETE}}, \""
        );
    }

    @GetMapping ("/all_customers")
    public List<Customer> findAllCustomers () {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer (@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/name/{name}")
    public List<Customer> getCustomereByName (@PathVariable String name) {

        return service.findByNameContaining(name);
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> addGuide (@RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCustomer (@PathVariable Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllCustomers (@RequestBody String confirm) {
        System.out.println(confirm);
        if (Objects.equals(confirm, "{\"confirm\":\"DELETE\"}")){
        service.deleteAll();}
    }
}
