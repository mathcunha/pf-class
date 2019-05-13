package com.pfclass.jpa.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pets")
@NamedQuery(name = "Pet.findByIdAndFetchVisitsEagerly", query = "SELECT p FROM Pet p JOIN FETCH p.visits WHERE p.id = (:id)")
public class Pet {
    protected Pet(){};

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Date birthDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Owner owner;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Type type;

    @OneToMany(mappedBy = "pet", fetch = FetchType.LAZY)
    private List<Visit> visits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
