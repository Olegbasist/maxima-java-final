package org.example.maximajavafinal.controller;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Mediator;
import org.example.maximajavafinal.service.BookingService;
import org.example.maximajavafinal.service.CustomerService;
import org.example.maximajavafinal.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ExcursionService excursionService;

    @GetMapping
    public String root () {
        return ("Available requests: "
                + "[\n" +
                "{\n" +
                "        \"request\": {\n" +
                "          \"method\": \"GET\",\n" +
                "          \"url\": \"http://localhost:8080/booking\",\n" +
                "          \"headers\": [\n" +
                "            {\n" +
                "              \"name\": \"\",\n" +
                "              \"value\": \"\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"postData\": {}\n" +
                "        }\n" +
                "      }\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/booking/signup\",\n" +
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
                "                \"name\": \"excursion_id\",\n" +
                "                \"value\": \"{id}\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"name\": \"customer_id\",\n" +
                "                \"value\": \"{id}\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"name\": \"quantity\",\n" +
                "                \"value\": \"{quantity}\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"excursion_id={id}&customer_id={id}&quantity={quantity}\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"request\": {\n" +
                "          \"method\": \"POST\",\n" +
                "          \"url\": \"http://localhost:8080/booking/signout\",\n" +
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
                "                \"name\": \"excursion_id\",\n" +
                "                \"value\": \"{id}\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"name\": \"customer_id\",\n" +
                "                \"value\": \"{id}\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"name\": \"quantity\",\n" +
                "                \"value\": \"{quantity}\"\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"excursion_id={id}&customer_id={id}&quantity={quantity}\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]"
        );
    }

    @PostMapping("/signup")
    public void signUpCustomerForExcursion (@RequestBody Mediator mediator) {
        Customer customer = customerService.findById(mediator.getCustomer_id());
        Excursion excursion = excursionService.findById(mediator.getExcursion_id());
        int quantity = mediator.getQuantity();
        bookingService.signUp(customer, excursion, quantity);
    }
    @PostMapping("/signout")
    public void signOutCustomerForExcursion (@RequestBody Mediator mediator) {
        Customer customer = customerService.findById(mediator.getCustomer_id());
        Excursion excursion = excursionService.findById(mediator.getExcursion_id());
        int quantity = mediator.getQuantity();
        bookingService.signOut(customer, excursion, quantity);
    }
}
