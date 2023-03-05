package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExcursionService {
    @Autowired private ExcursionRepository repository;

    public void save (Excursion excursion) {repository.save(excursion);}

    @Transactional(readOnly = true)
    public List<Excursion> findAll () {
        return repository.findAll();
    }

    @Transactional (readOnly = true)
    public Excursion findById (Long id) {return repository.findById(id).isPresent() ? repository.findById(id).get() : null;}

    public void deleteById (Long id) {repository.deleteById(id);}

    public void deleteAll () {repository.deleteAll();}
}
