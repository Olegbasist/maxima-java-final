package org.example.maximajavafinal.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.maximajavafinal.model.Assigner;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.ExcursionService;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public void assignGuideToExcursion (@RequestBody Assigner assigner) {
        Excursion excursionToAssign = excursionService.findById(assigner.getExcursion_id());
        Guide guideToAssign = guideService.findByID(assigner.getGuide_id());
        excursionService.assignGuideToExcursion(guideToAssign,excursionToAssign);
    }

    @PostMapping("/relive")
    public void reliveGuideFromExcursion (@RequestBody Excursion excursion){
        excursionService.reliveGuideFromExcursion(excursionService.findById(excursion.getId()));
    }
}
