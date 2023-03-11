package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "[\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/customer\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "         }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/customer/all_customers\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "         }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/customer/1\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"Content-Type\",\n" +
                "              \"value\": \"application/json\"\n" +
                "            }\n" +
                "          ],\n" +
                "         }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/customer/name/jan\",\n" +
                "          \"headers\": [],\n" +
                "          \"postData\": {\n" +
                "            \"mimeType\": \"\",\n" +
                "            \"params\": [],\n" +
                "            \"text\": \"name=jan\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/customer/new\",\n" +
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
                "                \"value\": \"Terminator T800\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"name=Terminator T800\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"DELETE\",\n" +
                "          \"url\": \"http://localhost:8080/customer/delete/1\",\n" +
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
                "          \"url\": \"http://localhost:8080/customer/delete/all\",\n" +
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
                "                \"name\": \"confirm\",\n" +
                "                \"value\": \"DELETE\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"confirm=DELETE\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]"
        );
    }

    @GetMapping ("/all_customers")
    public List<Customer> findAllCustomers () {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer (@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/name/{name}")
    public List<Customer> getCustomereByName (@PathVariable String name) {

        return service.findByNameContaining(name);
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> addGuide (@RequestBody Customer customer) {
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCustomer (@PathVariable Long id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllCustomers (@RequestBody String confirm) {
        if (Objects.equals(confirm, "{\"confirm\":\"DELETE\"}")){
        service.deleteAll();}
    }
}
