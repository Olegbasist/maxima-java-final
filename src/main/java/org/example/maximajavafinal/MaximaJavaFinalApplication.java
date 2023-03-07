package org.example.maximajavafinal;

import jakarta.annotation.PostConstruct;
import org.example.maximajavafinal.model.*;
import org.example.maximajavafinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MaximaJavaFinalApplication implements CommandLineRunner {
	
	@Autowired
	GuideService guideService;

	@Autowired
	ExcursionService excursionService;

	@Autowired
	TicketService ticketService;

	@Autowired
	CustomerService customerService;

	@Autowired
	BookingService bookingService;

	public static void main(String[] args) {
		SpringApplication.run(MaximaJavaFinalApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
		System.out.println("////////////////////////////////////////////////");
		System.out.println("Hallo! I'm Command Runner.");
		System.out.println("");
		System.out.println("This is our guides:");
		guideService.findAll().forEach(System.out::println);

		/*System.out.println("Get excursions connected to guide:");
		long i = 1;
		while (i<= guideService.findAll().size()) {
			System.out.println("");
			Guide guide = guideService.findByID(i);
			System.out.println("Guide " + guide.getName() + " signed on:");
			System.out.println(guide.getExcursions());
			i++;
		}*/

		System.out.println("");
		System.out.println("All available excursions: ");
		excursionService.findAll().forEach(System.out::println);
		System.out.println("");
		System.out.println("All available tickets: ");
		System.out.println(ticketService.findAll().size());
		System.out.println();

		System.out.println("Let's assign some Guide to Excursion:");
		Guide guide1L = guideService.findByID(1L);
		Excursion excursion = excursionService.findById(2L);
		excursionService.assignGuideToExcursion(guide1L, excursion);
		Excursion excursion1L = excursionService.findById(1L);
		excursionService.assignGuideToExcursion(guide1L, excursion1L);
		Excursion excursion3L = excursionService.findById(3L);
		excursionService.assignGuideToExcursion(guide1L, excursion3L);
		excursionService.findAll().forEach(excursion1 -> System.out.println(excursion1.getGuide()));
		System.out.println();

		System.out.println("Let's find out what excursions guide " +guide1L.getName()+ " assigned:");
		excursionService.findByGuide(guide1L.getId()).forEach(System.out::println);
		System.out.println();

		System.out.println("Our dear customers: ");
		customerService.findAll().forEach(System.out::println);
		System.out.println();

		String name = "tit";
		System.out.println("Let's find out user by name :" + name);
		customerService.findByNameContaining(name).forEach(customer -> System.out.println(customer));
		System.out.println();

		String gideName = "connor";
		System.out.println("Let's find out Gide by name :" + gideName);
		guideService.findByNameContaining(gideName).forEach(guide -> System.out.println(guide));
		System.out.println();


		System.out.println("Check in customer " + customerService.findById(1L).getName());
		bookingService.signUp(customerService.findById(1L), excursionService.findById(1L), 4);
		System.out.println("Result:");
		customerService.findById(1L).getTickets().forEach(System.out::println);
		System.out.println("And now new way:");
		ticketService.findAllTicketsByCustomerAndExcursion(1L,1L).forEach(System.out::println);


		System.out.println("");
		//ticketService.deleteById(ticket.getId());
		//customerService.findAll().forEach(System.out::println);
		//System.out.println(ticketService.findById(ticket.getId()));

		System.out.println("");
		System.out.println("All available tickets: ");
		System.out.println(ticketService.findAll().size());
		//excursionService.findAll().forEach(excursion -> System.out.println(excursion.getId() + " " + excursion.getTickets().size()));

	}


}
