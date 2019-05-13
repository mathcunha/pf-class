package com.pfclass.jpa.repository;

import com.pfclass.jpa.entity.Specialty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

    List<Specialty> findByName(String name);
}
