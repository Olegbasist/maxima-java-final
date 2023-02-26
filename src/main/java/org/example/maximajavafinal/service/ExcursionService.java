package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExcursionService {
    @Autowired private ExcursionRepository repository;

    public void save (Excursion excursion) {repository.save(excursion);}

    public List<Excursion> findAll () {
        return repository.findAll();
    }

    public Excursion findById (Long id) {return repository.findById(id).get();}


    public void deleteById (Long id) {repository.deleteById(id);}
}