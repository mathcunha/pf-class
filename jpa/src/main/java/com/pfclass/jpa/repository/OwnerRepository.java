package com.pfclass.jpa.repository;

import com.pfclass.jpa.entity.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    //TODO - https://www.baeldung.com/spring-data-jpa-query
    List<Owner> findByLastName(String lastName);
}
