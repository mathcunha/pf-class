package com.pfclass.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    protected Specialty() {}

    public Specialty(String name) {
        this.name= name;
    }

    @Override
    public String toString() {
        return String.format(
                "Specialty[id=%d, name='%s']",
                id, name);
    }
}
