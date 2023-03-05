package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuideService {
    @Autowired
    private GuideRepository repository;

    public void save (Guide newGuide) {repository.save(newGuide);}
    @Transactional (readOnly = true)
    public List<Guide> findAll () {
        return repository.findAll();
    }

    @Transactional (readOnly = true)
    public Guide findByID (Long id) {return repository.findById(id).isPresent() ? repository.findById(id).get() : null;}

    @Transactional (readOnly = true)
    public List<Guide> findByNameContaining (String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
    public void deleteById (Long id) {repository.deleteById(id);}

    public void deleteAll () {repository.deleteAll();}

}
