package com.pfclass.jpa.repository;

import com.pfclass.jpa.entity.Specialty;
import com.pfclass.jpa.entity.Vet;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VetRepositoryTest {
    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private SpecialtyRepository specRepository;


    @Test
    public void createVet()  {
        vetRepository.save(new Vet("Jack", "Bauer"));
        vetRepository.save(new Vet("Chloe", "O'Brian"));

        Vet vet = this.vetRepository.findByLastName("Bauer").get(0);
        assertThat(vet.getFirstName()).isEqualTo("Jack");
    }

    @Test
    public void createSpecialty()  {
        specRepository.save(new Specialty("Anesthesia"));
        specRepository.save(new Specialty("Behavior"));

        Specialty specialty = this.specRepository.findByName("Anesthesia").get(0);
        assertThat(specialty.getName()).isEqualTo("Anesthesia");
    }
}