package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
                + "POST: {/new}, Content-Type={application/json}, RequestBody={name=name}}, "
                + "DELETE: {/delete/{id}}, "
                + "DELETE: {/delete/all}, Content-Type={application/json}, RequestBody={confirm=DELETE}}, "
                );
    }
    
    @GetMapping("/all_guids")
    public List<Guide> getAllGuids (){
        return service.findAll();
    }
    //Ошибка: An error occurred while fetching the resource: AbortError: The operation was aborted.
    //Ушла после аннотирования tickets в Excursion аннотацией @JsonIgnore
    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuid (@PathVariable Long id) {
        return ResponseEntity.ok(service.findByID(id));
    }

    @GetMapping("/name/{name}")
    public List<Guide> getGuideByName (@PathVariable String name) {
        return service.findByNameContaining(name);
    }


    @PostMapping("/new")
    public ResponseEntity<Guide> addGuide (@RequestBody Guide guide) {
        service.save(guide);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteGuide (@PathVariable Long id) {
        service.deleteById(id);}

    @DeleteMapping("/delete/all")
    public void deleteAllGuids (@RequestBody String confirm) {
        System.out.println(confirm);
        if (Objects.equals(confirm, "{\"confirm\":\"DELETE\"}")){
            service.deleteAll();}
    }
}
