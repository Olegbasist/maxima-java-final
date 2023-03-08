package org.example.maximajavafinal;

import jakarta.annotation.PostConstruct;
import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.service.CustomerService;
import org.example.maximajavafinal.service.ExcursionService;
import org.example.maximajavafinal.service.GuideService;
import org.example.maximajavafinal.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;


@Component
public class TestEntitiesMaker {

    @Autowired
    private GuideService guideService;

    @Autowired
    ExcursionService excursionService;

    @Autowired
    TicketService ticketService;

    @Autowired
    CustomerService customerService;

    TestEntitiesMaker() {
    }

    @PostConstruct
    private void autoMakeTestEntities () {
        makeTestGuides(guideService);
        makeTestExcursions(5);
        makeTestCustomer(customerService);
    }
    private void makeTestGuides (GuideService guideService) {
        System.out.println("");
        System.out.print("Creating guides ... ");
        guideService.save(new Guide("Kyle Reese"));
        guideService.save(new Guide("Peter Silberman"));
        guideService.save(new Guide("John Connor"));
        guideService.save(new Guide("Miles Dyson"));
        guideService.save(new Guide("Sarah Connor"));

        System.out.println("");
        System.out.println("////////////////////////////////////////////////");
        /*System.out.println("Print guides list:");
        guideService.findAll().forEach(guide -> System.out.println(guide));
        System.out.println("////////////////////////////////////////////////");
        System.out.println("");*/


    }
    private void makeTestExcursions (int quantity) {

        System.out.println("Creating excursions and tickets ... ");
        int guidesCount = guideService.findAll().size()+1;

        while (quantity>0) {
            Excursion excursion = new Excursion();
            int year = new Random().nextInt(1997, 2048);

            String name = String.format("Tour to the incredible year of %s", year);
            excursion.setTitle(name);
            excursion.setDescription("Do you know what is the best thing about future? Well, you never feel obliged to take the same route when you are in time loop. At least, that’s what I did when I had a chance to change everything in several years past from now.");
            excursion.setGuide(guideService.findByID(new Random().nextLong(1,guidesCount)));
            excursion.setDate(new Date());
            excursion.setCapacity(20);
            excursionService.save(excursion);
            //ticketService.makeTickets(20,186,excursion);
            quantity--;
        }
        System.out.println("");
        System.out.println("////////////////////////////////////////////////");
        /*System.out.println("");
        System.out.println("Print excursions list:");
        excursionService.findAll().forEach(e -> System.out.println(e));
        System.out.println("");
        System.out.println("////////////////////////////////////////////////");*/
    }

    private void makeTestCustomer (CustomerService customerService) {
        customerService.save(new Customer("Posetitel","custom@mail.com"));
        customerService.save(new Customer("Posetitel2","custom2@mail.com"));
        customerService.save(new Customer("Posetitel3","custom3@mail.com"));
        customerService.save(new Customer("Janny","Call me later +49 221 112 22 11"));
        customerService.save(new Customer("Janna","Don't call me +49 485 158 32 11"));
    }
    public void makeTestCustomersByQuantity (int quantity, CustomerService customerService) {
        System.out.println("Creating some customers ...");
        while (quantity>0){
            customerService.save(new Customer("Name","Phone: +486874955574"));
        }
    }
}
