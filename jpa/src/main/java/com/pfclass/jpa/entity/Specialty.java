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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "specialty_id"),
            inverseJoinColumns = @JoinColumn(name = "vet_id"))
    private List<Vet> vets;

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

    public void setVets(List<Vet> vets) {
        this.vets = vets;
    }
}
