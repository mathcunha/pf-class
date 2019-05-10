package com.pfclass.jpa.repository;

import java.util.List;

import com.pfclass.jpa.entity.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
    //TODO - https://www.baeldung.com/spring-data-jpa-query
    List<Vet> findByLastName(String lastName);
}
