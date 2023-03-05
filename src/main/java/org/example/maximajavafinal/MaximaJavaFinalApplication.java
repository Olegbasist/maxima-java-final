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
	TestEntitiesMaker testEntitiesMaker;

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

		System.out.println("");

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

		Customer customer1 = customerService.findById(1L);
		System.out.println("Check in customer " + customer1.getName());
		bookingService.signUp(customer1, excursionService.findById(1L), 4);
		System.out.println("Result:");
		customerService.findById(customer1.getId()).getTickets().forEach(System.out::println);

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
