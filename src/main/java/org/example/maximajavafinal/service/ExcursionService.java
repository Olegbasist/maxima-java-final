package org.example.maximajavafinal.service;

import org.example.maximajavafinal.exception.ExcursionNotFoundException;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
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
    public Excursion findById (Long id) {
        return repository.findById(id).orElseThrow(()-> new ExcursionNotFoundException(id.toString()));}

    @Transactional (readOnly = true)
    public List<Excursion> findByTitle (String title){
        return repository.findByTitleContainingIgnoreCase(title);
    }

    @Transactional (readOnly = true)
    public List<Excursion> findByGuide (long id) {
        return repository.findByGuide_Id(id);
    }
    public void assignGuideToExcursion (Guide guide, Excursion excursion) {
        excursion.setGuide(guide);
        save(excursion);
    }

    public void reliveGuideFromExcursion(Excursion excursion) {
        assignGuideToExcursion(null,excursion);
    }
    public void deleteById (Long id) {repository.deleteById(id);}

    public void deleteAll () {repository.deleteAll();}
}
