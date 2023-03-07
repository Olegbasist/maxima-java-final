package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController //Приводит к ошибке Multiple representations of the same entity [org.example.maximajavafinal.model.Excursion#1]
@RequestMapping("/")
public class GuideController {

    @Autowired
    private GuideService service;

    @GetMapping("/all_guids")
    public List<Guide> findAll (){
        return service.findAll();
    }
}
