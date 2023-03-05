package org.example.maximajavafinal.service;
import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public void save (Customer customer) {repository.save(customer);}

    public List<Customer> findAll () {
        return repository.findAll();
    }

    public Customer findById (Long id) {return repository.findById(id).get();}


    public void deleteById (Long id) {repository.deleteById(id);}

    public void deleteAll () {repository.deleteAll();}
}
