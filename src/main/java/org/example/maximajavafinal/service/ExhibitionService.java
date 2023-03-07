package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Exhibition;
import org.example.maximajavafinal.repository.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitionService {

    @Autowired
    private ExhibitionRepository repository;

    public void save (Exhibition exhibition) {
        repository.save(exhibition);
    }

    public List<Exhibition> findAll (){
        return repository.findAll();
    }
}
