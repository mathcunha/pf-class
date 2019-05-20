/*
 * This file is generated by jOOQ.
 */
package com.pfclass.db.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


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
@Table(name = "vet_specialties", schema = "petclinic", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"vet_id", "specialty_id"})
}, indexes = {
    @Index(name = "specialty_id", columnList = "specialty_id ASC"),
    @Index(name = "vet_id", unique = true, columnList = "vet_id ASC, specialty_id ASC")
})
public class VetSpecialties implements Serializable {

    private static final long serialVersionUID = -618615873;

    private Integer vetId;
    private Integer specialtyId;

    public VetSpecialties() {}

    public VetSpecialties(VetSpecialties value) {
        this.vetId = value.vetId;
        this.specialtyId = value.specialtyId;
    }

    public VetSpecialties(
        Integer vetId,
        Integer specialtyId
    ) {
        this.vetId = vetId;
        this.specialtyId = specialtyId;
    }

    @Column(name = "vet_id", nullable = false, precision = 10)
    @NotNull
    public Integer getVetId() {
        return this.vetId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }

    @Column(name = "specialty_id", nullable = false, precision = 10)
    @NotNull
    public Integer getSpecialtyId() {
        return this.specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VetSpecialties (");

        sb.append(vetId);
        sb.append(", ").append(specialtyId);

        sb.append(")");
        return sb.toString();
    }
}
