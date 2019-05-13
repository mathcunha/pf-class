package com.pfclass.jpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit {
    protected Visit(){};

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String description;
    private Date visitDate;

    public Visit(String description, Date visitDate, Pet pet) {
        this.description = description;
        this.visitDate = visitDate;
        this.pet = pet;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pet pet;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", visitDate=" + visitDate +
                ", pet=" + pet +
                '}';
    }
}
