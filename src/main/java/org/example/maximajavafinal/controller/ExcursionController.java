package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
                + "POST: {/new}, Content-Type={application/json}, RequestBody={title=title}}, "
                + "DELETE: {/delete/{id}}, "
                + "DELETE: {/delete/all}, Content-Type={application/json}, RequestBody={confirm=DELETE}}, "
        );
    }
    @GetMapping("/all_excursions")
    public List<Excursion> findAll(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Excursion> getExcursion (@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Excursion> addGuide (@RequestBody Excursion excursion) {
        service.save(excursion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteExcursion (@PathVariable Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllExcursions (@RequestBody String confirm) {
        if (Objects.equals(confirm, "{\"confirm\":\"DELETE\"}")){
            service.deleteAll();}
    }
}
