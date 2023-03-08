package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/guide")
public class GuideController {

    @Autowired
    private GuideService service;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "GET: {/all_guids}, "
                + "GET: {/{id}}, "
                + "GET: {/name/{string}}, "
                );
    }
    
    @GetMapping("/all_guids")
    public List<Guide> findAllGuids (){
        return service.findAll();
    }
    //Ошибка: An error occurred while fetching the resource: AbortError: The operation was aborted.
    //Ушла после аннотирования tickets в Excursion аннотацией @JsonIgnore
    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuid (@PathVariable Long id) {
        return ResponseEntity.ok(service.findByID(id));
    }

    @GetMapping("/name/{string}")
    public List<Guide> findGuideByName (@PathVariable String string) {
        return service.findByNameContaining(string);
    }
}
