package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Mediator;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.ExcursionService;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                + "POST: {/assign}, Content-Type={application/json}, RequestBody={excursion_id=id},{guide_id=id}}, "
                + "POST: {/relive}, Content-Type={application/json}, RequestBody={id=id}}, "
        );
    }

    @PostMapping("/assign")
    public void assignGuideToExcursion (@RequestBody Mediator mediator) {
        Excursion excursionToAssign = excursionService.findById(mediator.getExcursion_id());
        Guide guideToAssign = guideService.findByID(mediator.getGuide_id());
        excursionService.assignGuideToExcursion(guideToAssign,excursionToAssign);
    }

    @PostMapping("/relive")
    public void reliveGuideFromExcursion (@RequestBody Excursion excursion){
        excursionService.reliveGuideFromExcursion(excursionService.findById(excursion.getId()));
    }
}
