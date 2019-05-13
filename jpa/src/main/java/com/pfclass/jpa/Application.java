package com.pfclass.jpa;

import com.pfclass.jpa.entity.Specialty;
import com.pfclass.jpa.entity.Vet;
import com.pfclass.jpa.repository.SpecialtyRepository;
import com.pfclass.jpa.repository.VetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demoSpecialty(SpecialtyRepository repository) {
        return (args) -> {
            // save a couple of vets
            repository.save(new Specialty("Anesthesia"));
            repository.save(new Specialty("Behavior"));
            repository.save(new Specialty("Dermatology"));
            repository.save(new Specialty("Dentistry"));
            repository.save(new Specialty("Animal Welfare"));

            // fetch all vets
            log.info("Vets found with findAll():");
            log.info("-------------------------------");
            for (Specialty spec : repository.findAll()) {
                log.info(spec.toString());
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

            // for (Vet bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner demoVet(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
        return (args) -> {
            // save a couple of vets
            vetRepository.save(new Vet("Jack", "Bauer"));
            vetRepository.save(new Vet("Chloe", "O'Brian"));
            vetRepository.save(new Vet("Kim", "Bauer"));
            vetRepository.save(new Vet("David", "Palmer"));
            vetRepository.save(new Vet("Michelle", "Dessler"));

            // fetch all vets
            log.info("Vets found with findAll():");
            log.info("-------------------------------");
            for (Vet vet : vetRepository.findAll()) {
                log.info(vet.toString());
            }
            log.info("");

            // fetch an individual vet by ID
            vetRepository.findById(6L)
                    .ifPresent(vet -> {
                        log.info("Vet found with findById(6L):");
                        log.info("--------------------------------");
                        log.info(vet.toString());
                        log.info("");
                        specialtyRepository.findById(1L)
                                .ifPresent(spec -> {
                                    Set<Specialty> specialties = new HashSet<>(1);
                                    specialties.add(spec);
                                    vet.setSpecialties(specialties);
                                    log.info("Updating Vet specialties");
                                    vetRepository.save(vet);
                                });
                    });

            // fetch vets by last name
            log.info("Vet found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            vetRepository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Vet bauer : vetRepository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}