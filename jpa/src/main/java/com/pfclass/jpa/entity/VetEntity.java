package com.pfclass.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vet")
public class VetEntity {
    //TODO - https://spring.io/guides/gs/accessing-data-jpa/
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    public VetEntity(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }

        if(!(obj instanceof VetEntity)){
            return false;
        }

        VetEntity vet = (VetEntity) obj;

        return vet.getId().equals(this.getId()) && vet.getLastName().equals(this.getLastName()) && vet.getFirstName().equals(this.getFirstName());
    }
}
