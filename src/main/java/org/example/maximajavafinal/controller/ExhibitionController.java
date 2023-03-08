package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Exhibition;
import org.example.maximajavafinal.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExhibitionController {

    @Autowired
    private ExhibitionService service;

    @GetMapping("exhibitions")
    public List<Exhibition> findAllExhibitions() {return service.findAll();}

    @PostMapping("/new")
    public ResponseEntity<Exhibition> addGuide (@RequestBody Exhibition exhibition) {
        service.save(exhibition);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
