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
                + "[\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/guide\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"\",\n" +
                "              \"value\": \"\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {}\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/guide/all_guids\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"\",\n" +
                "              \"value\": \"\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {}\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/guide/{id}\",\n" +
                "          \"headers\": [],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"\",\n" +
                "            \"params\": [],\n" +
                "            \"text\": \"\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/guide/name/{name}\",\n" +
                "          \"headers\": [],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"\",\n" +
                "            \"params\": [],\n" +
                "            \"text\": \"\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/guide/new\",\n" +
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
                "                \"name\": \"name\",\n" +
                "                \"value\": \"{name}\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"name={name}\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"PATCH\",\n" +
                "          \"url\": \"http://localhost:8080/guide/update\",\n" +
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
                "                \"name\": \"name\",\n" +
                "                \"value\": \"{name}\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"id={id}&name={name}\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/guide/service/assign\",\n" +
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
                "                \"name\": \"guide_id\",\n" +
                "                \"value\": \"{id}\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"name\": \"excursion_id\",\n" +
                "                \"value\": \"{id}\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"guide_id={id}&excursion_id={id}\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/guide/service/relive\",\n" +
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
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"id={id}\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"DELETE\",\n" +
                "          \"url\": \"http://localhost:8080/guide/delete/{id}\",\n" +
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
                "          \"url\": \"http://localhost:8080/guide/delete/all\",\n" +
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
    public ResponseEntity<List<Guide>> getGuideByName (@PathVariable String name) {
        return ResponseEntity.ok(service.findByNameContaining(name));
    }


    @PostMapping("/new")
    public ResponseEntity<Guide> addGuide (@RequestBody Guide guide) {
        service.save(guide);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<Guide> updateGuide (@RequestBody Guide updatedGuide) {
        Guide guideForUpdate = service.findByID(updatedGuide.getId());
        if (updatedGuide.getName() != null) {guideForUpdate.setName(updatedGuide.getName());}
        service.save(guideForUpdate);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGuide (@PathVariable Long id) {
        service.deleteById(id);}

    @DeleteMapping("/delete/all")
    public void deleteAllGuids (@RequestBody String confirm) {
        if (Objects.equals(confirm, "{\"confirm\":\"DELETE\"}")){
            service.deleteAll();}
    }
}
