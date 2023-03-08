package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excursion")
public class ExcursionController {

    @Autowired
    private ExcursionService service;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "GET:{all_excursions}, "
                + "GET:{id}"
                + "{}"
                + "{}"
                + "{}");
    }
    @GetMapping("/all_excursions")
    public List<Excursion> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Excursion getTicket (@PathVariable Long id) {
        return service.findById(id);
    }
}
