/*
 * This file is generated by jOOQ.
 */
package com.pfclass.db.generated;


import com.pfclass.db.generated.tables.Owners;
import com.pfclass.db.generated.tables.Pets;
import com.pfclass.db.generated.tables.Specialties;
import com.pfclass.db.generated.tables.Types;
import com.pfclass.db.generated.tables.VetSpecialties;
import com.pfclass.db.generated.tables.Vets;
import com.pfclass.db.generated.tables.Visits;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in petclinic
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>petclinic.owners</code>.
     */
    public static final Owners OWNERS = com.pfclass.db.generated.tables.Owners.OWNERS;

    /**
     * The table <code>petclinic.pets</code>.
     */
    public static final Pets PETS = com.pfclass.db.generated.tables.Pets.PETS;

    /**
     * The table <code>petclinic.specialties</code>.
     */
    public static final Specialties SPECIALTIES = com.pfclass.db.generated.tables.Specialties.SPECIALTIES;

    /**
     * The table <code>petclinic.types</code>.
     */
    public static final Types TYPES = com.pfclass.db.generated.tables.Types.TYPES;

    /**
     * The table <code>petclinic.vet_specialties</code>.
     */
    public static final VetSpecialties VET_SPECIALTIES = com.pfclass.db.generated.tables.VetSpecialties.VET_SPECIALTIES;

    /**
     * The table <code>petclinic.vets</code>.
     */
    public static final Vets VETS = com.pfclass.db.generated.tables.Vets.VETS;

    /**
     * The table <code>petclinic.visits</code>.
     */
    public static final Visits VISITS = com.pfclass.db.generated.tables.Visits.VISITS;
}