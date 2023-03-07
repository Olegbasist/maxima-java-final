package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Exhibition;
import org.example.maximajavafinal.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExhibitionController {

    @Autowired
    private ExhibitionService exhibitionService;

    @GetMapping("exhibitions")
    public List<Exhibition> findAllExhibitions() {return exhibitionService.findAll();}
}
