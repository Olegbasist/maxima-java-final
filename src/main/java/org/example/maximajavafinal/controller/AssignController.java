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
@RequestMapping("/guide")
public class AssignController {

    @Autowired
    private ExcursionService excursionService;

    @Autowired
    private GuideService guideService;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "POST: {/assign}, Content-Type={application/json}, RequestBody={guide_id=id},{excursion_id=id}}, "
                + "POST: {/relive}, Content-Type={application/json}, RequestBody={excursion_id=id}}, "
        );
    }

    @PostMapping("/assign")
    public void assignGuideToExcursion (@RequestBody Long guide_id, Long excursion_id){
        Excursion excursion = excursionService.findById(excursion_id);
        Guide guide = guideService.findByID(guide_id);
        excursionService.assignGuideToExcursion(guide,excursion);
    }

    @PostMapping("/relive")
    public void reliveGuideFromExcursion (@RequestBody Long excursion_id){
        Excursion excursion = excursionService.findById(excursion_id);
        excursionService.reliveGuideFromExcursion(excursion);
    }
}
