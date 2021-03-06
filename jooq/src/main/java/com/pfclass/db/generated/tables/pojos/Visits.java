/*
 * This file is generated by jOOQ.
 */
package com.pfclass.db.generated.tables.pojos;


import java.io.Serializable;
import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "visits", schema = "petclinic", indexes = {
    @Index(name = "pet_id", columnList = "pet_id ASC"),
    @Index(name = "PRIMARY", unique = true, columnList = "id ASC")
})
public class Visits implements Serializable {

    private static final long serialVersionUID = 300894268;

    private Integer id;
    private Integer petId;
    private Date    visitDate;
    private String  description;

    public Visits() {}

    public Visits(Visits value) {
        this.id = value.id;
        this.petId = value.petId;
        this.visitDate = value.visitDate;
        this.description = value.description;
    }

    public Visits(
        Integer id,
        Integer petId,
        Date    visitDate,
        String  description
    ) {
        this.id = id;
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 10)
    @NotNull
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "pet_id", nullable = false, precision = 10)
    @NotNull
    public Integer getPetId() {
        return this.petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    @Column(name = "visit_date")
    public Date getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Column(name = "description", length = 255)
    @Size(max = 255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Visits (");

        sb.append(id);
        sb.append(", ").append(petId);
        sb.append(", ").append(visitDate);
        sb.append(", ").append(description);

        sb.append(")");
        return sb.toString();
    }
}
