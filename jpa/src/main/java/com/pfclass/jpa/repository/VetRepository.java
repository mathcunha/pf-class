package com.pfclass.jpa.repository;

import java.util.List;

import com.pfclass.jpa.entity.VetEntity;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<VetEntity, Long> {

    List<VetEntity> findByLastName(String lastName);
}
