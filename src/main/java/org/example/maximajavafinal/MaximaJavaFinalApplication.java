package org.example.maximajavafinal;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.repository.ExcursionRepository;
import org.example.maximajavafinal.repository.GuideRepository;
import org.example.maximajavafinal.service.ExcursionService;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaximaJavaFinalApplication implements CommandLineRunner {

	@Autowired TestEntitiesMaker testEntitiesMaker;

	public static void main(String[] args) {
		SpringApplication.run(MaximaJavaFinalApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
		System.out.println("////////////////////////////////////////////////");
		System.out.println("Hallo! I'm Command Runner.");
		System.out.println("");

		//tests();
	}
	private void tests(){
		System.out.println("Let's do some tests!");
	}


}
