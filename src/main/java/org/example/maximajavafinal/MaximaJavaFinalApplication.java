package org.example.maximajavafinal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaximaJavaFinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaximaJavaFinalApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo! I'm Command Runner.");
		addTestEntities();
		//tests();
	}
	private static void addTestEntities () {
		System.out.println("Creating guides ... ");

		System.out.println("Creating excursions and tickets ... ");

	}
	private static void tests(){
		System.out.println("Let's do some tests!");
	}


}
