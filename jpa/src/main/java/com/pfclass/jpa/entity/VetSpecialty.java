package com.pfclass.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "vet_specialties")
public class VetSpecialty {
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @Column(name = "vet_id")
    private Vet vet;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @Column(name = "specialty_id")
    private Specialty specialty;
}
