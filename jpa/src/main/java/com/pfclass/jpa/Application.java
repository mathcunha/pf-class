package com.pfclass.jpa;

import com.pfclass.jpa.entity.Vet;
import com.pfclass.jpa.repository.VetDAO;
import com.pfclass.jpa.repository.VetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(VetDAO repository) {
        return (args) -> {
            // save a couple of vets
            repository.save(new Vet("Jack", "Bauer"));
            repository.save(new Vet("Chloe", "O'Brian"));
            repository.save(new Vet("Kim", "Bauer"));
            repository.save(new Vet("David", "Palmer"));
            repository.save(new Vet("Michelle", "Dessler"));

            // fetch all vets
            log.info("Vets found with findAll():");
            log.info("-------------------------------");
            for (Vet vet : repository.findAll()) {
                log.info(vet.toString());
            }
            log.info("");

            // fetch an individual vet by ID
            repository.findById(1L)
                    .ifPresent(vet -> {
                        log.info("Vet found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(vet.toString());
                        log.info("");
                    });

            // fetch vets by last name
            log.info("Vet found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Vet bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}