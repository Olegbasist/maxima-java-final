package org.example.maximajavafinal.service;


import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcursionServiceCopy extends SuperService <Excursion>{

    @Autowired
    private ExcursionRepository repository;

}
