package com.pfclass.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types")
@NamedQuery(name = "Type.findByIdAndFetchPetsEagerly", query = "SELECT t FROM Type t JOIN FETCH t.pets WHERE t.id = (:id)")
public class Type {

    protected Type(){};

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private List<Pet> pets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type(String name) {
        this.name= name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
