package com.pfclass.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class VetRepositoryJPA {
    @Autowired
    private EntityManager em;
}
