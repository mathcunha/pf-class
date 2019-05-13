package com.pfclass.jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties;

    protected Vet() {}

    public Vet(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Specialty> getSpecialties(){
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties){
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return String.format(
                "Vet[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}