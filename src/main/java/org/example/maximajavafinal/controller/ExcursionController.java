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
                + "[\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/excursion/all_excursions\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"\",\n" +
                "              \"value\": \"\"\n" +
                "            }\n" +
                "          ],\n" +

                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/excursion/{id}\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"\",\n" +
                "              \"value\": \"\"\n" +
                "            }\n" +
                "          ],\n" +

                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/excursion/new\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"application/x-www-form-urlencoded\",\n" +
                "            \"params\": [\n" +
                "              {\n" +
                "                \"name\": \"title\",\n" +
                "                \"value\": \"{title}\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"title={title}\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"PATCH\",\n" +
                "          \"url\": \"http://localhost:8080/excursion/update\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"application/x-www-form-urlencoded\",\n" +
                "            \"params\": [\n" +
                "              {\n" +
                "                \"name\": \"id\",\n" +
                "                \"value\": \"{id}\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"name\": \"title\",\n" +
                "                \"value\": \"{title}\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"id={id}&title={title}\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"DELETE\",\n" +
                "          \"url\": \"http://localhost:8080/excursion/delete/{id}\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"\",\n" +
                "            \"params\": [],\n" +
                "            \"text\": \"confirm=DELETE\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"DELETE\",\n" +
                "          \"url\": \"http://localhost:8080/excursion/delete/all\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"\",\n" +
                "            \"params\": [],\n" +
                "            \"text\": \"confirm=DELETE\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]"
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

    @PatchMapping ("/update")
    public ResponseEntity<Excursion> updateGuide (@RequestBody Excursion updatedExcursion) {
        Excursion excursionForUpdate = service.findById(updatedExcursion.getId());
        if (updatedExcursion.getTitle() != null)  {excursionForUpdate.setTitle(updatedExcursion.getTitle());}
        if (updatedExcursion.getDescription() != null){excursionForUpdate.setDescription(updatedExcursion.getDescription());}
        if (updatedExcursion.getCapacity() != 0) {excursionForUpdate.setCapacity(updatedExcursion.getCapacity());}
        if (updatedExcursion.getDate() != null) {excursionForUpdate.setDate(updatedExcursion.getDate());}
        service.save(excursionForUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
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
