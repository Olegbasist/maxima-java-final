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
	ExcursionServiceCopy excursionServiceCopy;

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
		//new TestEntitiesMaker().makeTestCustomers(5);
		customerService.save(new Customer("Posetitel","custom@mail.com"));
		customerService.save(new Customer("Janny","Call me later +49 221 112 22 11"));
		System.out.println("Our dear customers: ");
		customerService.findAll().forEach(System.out::println);
		System.out.println("");

		Customer customer1 = customerService.findById(1L);
		System.out.println("Check in customer " + customer1.getName());
		bookingService.signUp(customer1, excursionService.findById(1L), 4);
		System.out.println("Result:");
		System.out.println();
		customerService.findById(customer1.getId()).getTickets().forEach(System.out::println);

		System.out.println("");
		//ticketService.deleteById(ticket.getId());
		//customerService.findAll().forEach(System.out::println);
		//System.out.println(ticketService.findById(ticket.getId()));

		System.out.println("");
		System.out.println("All available tickets: ");
		System.out.println(ticketService.findAll().size());
		//excursionService.findAll().forEach(excursion -> System.out.println(excursion.getId() + " " + excursion.getTickets().size()));

		System.out.println("Try to call generic method:");
		//excursionServiceCopy.findAll();

	}


}
