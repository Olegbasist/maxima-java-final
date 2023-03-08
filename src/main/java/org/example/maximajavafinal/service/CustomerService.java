package org.example.maximajavafinal.service;
import org.example.maximajavafinal.exception.CustomerNotFoundException;
import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public void save (Customer customer) {repository.save(customer);}

    @Transactional(readOnly = true)
    public List<Customer> findAll () {return repository.findAll();}

    @Transactional(readOnly = true)
    public Customer findById (Long id) {return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id.toString()));}

    @Transactional (readOnly = true)
    public List<Customer> findByNameContaining (String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public void deleteById (Long id) {repository.deleteById(id);}

    public void deleteAll () {repository.deleteAll();}
}
