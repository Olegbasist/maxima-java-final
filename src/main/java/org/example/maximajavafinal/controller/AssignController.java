package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.ExcursionService;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/guide/service")
public class AssignController {

    @Autowired
    private ExcursionService excursionService;

    @Autowired
    private GuideService guideService;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "POST: {/assign}, Content-Type={application/json}, RequestBody={id=id},{id=id}}, "
                + "POST: {/relive}, Content-Type={application/json}, RequestBody={id=id}}, "
        );
    }

    @PostMapping("/assign")
    public void assignGuideToExcursion (@RequestBody Guide guide, Excursion excursion){
        System.out.println(guide);
        //System.out.println(excursion);
        Excursion excursionToAssign = excursionService.findById(excursion.getId());
        Guide guideToAssign = guideService.findByID(guide.getId());
        excursionService.assignGuideToExcursion(guideToAssign,excursionToAssign);
    }

    @PostMapping("/relive")
    public void reliveGuideFromExcursion (@RequestBody Excursion excursion){
        excursionService.reliveGuideFromExcursion(excursionService.findById(excursion.getId()));
    }
}
