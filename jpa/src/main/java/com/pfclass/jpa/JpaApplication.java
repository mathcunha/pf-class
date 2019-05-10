package com.pfclass.jpa;

import com.pfclass.jpa.entity.VetEntity;
import com.pfclass.jpa.repository.VetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VetRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new VetEntity("Jack", "Bauer"));
			repository.save(new VetEntity("Chloe", "O'Brian"));
			repository.save(new VetEntity("Kim", "Bauer"));
			repository.save(new VetEntity("David", "Palmer"));
			repository.save(new VetEntity("Michelle", "Dessler"));

			// fetch all customers
			log.info("VetEntitys found with findAll():");
			log.info("-------------------------------");
			for (VetEntity customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
					.ifPresent(customer -> {
						log.info("VetEntity found with findById(1L):");
						log.info("--------------------------------");
						log.info(customer.toString());
						log.info("");
					});

			// fetch customers by last name
			log.info("VetEntity found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (VetEntity bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
