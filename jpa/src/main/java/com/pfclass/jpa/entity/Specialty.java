package com.pfclass.jpa.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "specialty_id"),
            inverseJoinColumns = @JoinColumn(name = "vet_id"))
    List<Vet> vets;

    protected Specialty() {}

    public List<Vet> getVets(){
        return vets;
    }

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
