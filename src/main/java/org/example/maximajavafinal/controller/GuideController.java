package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GuideController {

    @Autowired
    private GuideService service;

    public List<Guide> findAll (){
        return service.findAll();
    }
}
