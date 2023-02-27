package org.example.maximajavafinal;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.model.Product;
import org.example.maximajavafinal.service.CustomerService;
import org.example.maximajavafinal.service.ExcursionService;
import org.example.maximajavafinal.service.GuideService;
import org.example.maximajavafinal.service.TicketService;
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

	public static void main(String[] args) {
		SpringApplication.run(MaximaJavaFinalApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
		System.out.println("////////////////////////////////////////////////");
		System.out.println("Hallo! I'm Command Runner.");
		System.out.println("");
		//guideService.findAll().forEach(System.out::println);
		System.out.println("");
		System.out.println("Get excursions connected to guide:");
		long i = 1;
		while (i<= guideService.findAll().size()) {
			System.out.println("");
			Guide guide = guideService.findByID(i);
			System.out.println("Guide " + guide.getName() + " signed on:");
			System.out.println(guide.getExcursions());
			i++;
		}

		//List<Excursion> excursions = excursionService.findAll();
		//excursions.forEach(System.out::println);

		//guideService.findByID(1L).setExcursions(excursions);
		//guideService.findAll().forEach(System.out::println);


	}


}
