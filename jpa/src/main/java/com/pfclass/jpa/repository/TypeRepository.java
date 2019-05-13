package com.pfclass.jpa.repository;

import com.pfclass.jpa.entity.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Long> {
    //TODO - https://www.baeldung.com/spring-data-jpa-query
    List<Type> findByName(String name);

    List<Type> findByIdAndFetchPetsEagerly(@Param("id") Long id);
}
