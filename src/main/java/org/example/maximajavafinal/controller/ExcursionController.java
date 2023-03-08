package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excursion")
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "GET:{all_excursions}, "
                + "{}"
                + "{}"
                + "{}"
                + "{}");
    }
    @GetMapping("/all_excursions")
    public List<Excursion> findAll(){
        return excursionService.findAll();
    }
}
