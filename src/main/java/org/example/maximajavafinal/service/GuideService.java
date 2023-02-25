package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService {
    @Autowired
    private GuideRepository repository;

    public List<Guide> getAllGuides () {
        return repository.findAll();
    }

    public void saveGuide (Guide newGuide) {
        repository.save(newGuide);
    }

}
