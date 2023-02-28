package org.example.maximajavafinal;

import jakarta.annotation.PostConstruct;
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
    GuideService guideService;

    @Autowired
    ExcursionService excursionService;

    @Autowired
    TicketService ticketService;

    @Autowired
    CustomerService customerService;

    public TestEntitiesMaker() {
    }

    @PostConstruct
    private void autoMakTestEntities () {
        makeTestGuides();
        makeTestExcursions(5);
    }
    public void makeTestGuides () {
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
    public void makeTestExcursions (int count) {

        System.out.println("Creating excursions and tickets ... ");
        int guidesCount = guideService.findAll().size()+1;
        int i=0;
        while (i<count) {
            Excursion excursion = new Excursion();
            int year = new Random().nextInt(1997, 2048);

            String name = String.format("Tour to the incredible year of %s", year);
            excursion.setName(name);
            excursion.setDescription("Do you know what is the best thing about future? Well, you never feel obliged to take the same route when you are in time loop. At least, that’s what I did when I had a chance to change everything in several years past from now.");
            excursion.setGuide(guideService.findByID(new Random().nextLong(1,guidesCount)));
            excursion.setDate(new Date());
            excursionService.save(excursion);
            ticketService.makeTickets(20,186,excursion);
            i++;
        }
        System.out.println("");
        System.out.println("////////////////////////////////////////////////");
        /*System.out.println("");
        System.out.println("Print excursions list:");
        excursionService.findAll().forEach(e -> System.out.println(e));
        System.out.println("");
        System.out.println("////////////////////////////////////////////////");*/
    }
}
