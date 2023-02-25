package org.example.maximajavafinal;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.example.maximajavafinal.repository.ExcursionRepository;
import org.example.maximajavafinal.repository.GuideRepository;
import org.example.maximajavafinal.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaximaJavaFinalApplication implements CommandLineRunner {

	@Autowired
	GuideService guideService;

	@Autowired
	ExcursionRepository excursionRepository;
	public static void main(String[] args) {
		SpringApplication.run(MaximaJavaFinalApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo! I'm Command Runner.");
		addTestEntities();
		//tests();
	}
	private void addTestEntities () {
		System.out.println("Creating guides ... ");

		/*guideRepository.save(new Guide("Гид"));
		guideRepository.findAll().forEach(guide -> System.out.println(guide));*/


		guideService.saveGuide(new Guide("'Безымянный гид'"));
		guideService.saveGuide(new Guide("Konstantin Stratowsky"));
		guideService.saveGuide(new Guide("Anna Tener"));
		guideService.saveGuide(new Guide("John Smith"));

		System.out.println("Наши гиды:");
		guideService.getAllGuides().forEach(guide -> System.out.println(guide));


		System.out.println("Creating excursions and tickets ... ");
		//excursionRepository.save(new Excursion());
		Excursion excursion = new Excursion();
		excursion.setName("First tour");
		excursion.setDescription("Очень познавательная экскурсия по кракозябрам и буеракам.");
		excursionRepository.save(excursion);
		excursionRepository.findAll().forEach(e -> System.out.println(e));

	}
	private void tests(){
		System.out.println("Let's do some tests!");
	}


}
