package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.repository.BaseRepository;
import org.example.maximajavafinal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class SuperService<T> {

    @Autowired
    private BaseRepository repository;

    public void save (T t) {repository.save(t);}
    public List<Object> findAll () {
        return repository.findAll();
    }
    public T findById (Long id) {return (T) repository.findById(id).get();}
    public void deleteById (Long id) {repository.deleteById(id);}
}
