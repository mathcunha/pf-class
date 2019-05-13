package com.pfclass.jpa.repository;

import com.pfclass.jpa.entity.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {
    //TODO - https://www.baeldung.com/spring-data-jpa-query
    List<Pet> findByName(String name);

    Pet findByIdAndFetchVisitsEagerly(@Param("id") Long id);
}
