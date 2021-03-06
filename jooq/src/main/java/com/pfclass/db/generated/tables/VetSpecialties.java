/*
 * This file is generated by jOOQ.
 */
package com.pfclass.db.generated.tables;


import com.pfclass.db.generated.Indexes;
import com.pfclass.db.generated.Keys;
import com.pfclass.db.generated.Petclinic;
import com.pfclass.db.generated.tables.records.VetSpecialtiesRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class VetSpecialties extends TableImpl<VetSpecialtiesRecord> {

    private static final long serialVersionUID = -2063318084;

    /**
     * The reference instance of <code>petclinic.vet_specialties</code>
     */
    public static final VetSpecialties VET_SPECIALTIES = new VetSpecialties();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VetSpecialtiesRecord> getRecordType() {
        return VetSpecialtiesRecord.class;
    }

    /**
     * The column <code>petclinic.vet_specialties.vet_id</code>.
     */
    public final TableField<VetSpecialtiesRecord, Integer> VET_ID = createField("vet_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>petclinic.vet_specialties.specialty_id</code>.
     */
    public final TableField<VetSpecialtiesRecord, Integer> SPECIALTY_ID = createField("specialty_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>petclinic.vet_specialties</code> table reference
     */
    public VetSpecialties() {
        this(DSL.name("vet_specialties"), null);
    }

    /**
     * Create an aliased <code>petclinic.vet_specialties</code> table reference
     */
    public VetSpecialties(String alias) {
        this(DSL.name(alias), VET_SPECIALTIES);
    }

    /**
     * Create an aliased <code>petclinic.vet_specialties</code> table reference
     */
    public VetSpecialties(Name alias) {
        this(alias, VET_SPECIALTIES);
    }

    private VetSpecialties(Name alias, Table<VetSpecialtiesRecord> aliased) {
        this(alias, aliased, null);
    }

    private VetSpecialties(Name alias, Table<VetSpecialtiesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> VetSpecialties(Table<O> child, ForeignKey<O, VetSpecialtiesRecord> key) {
        super(child, key, VET_SPECIALTIES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Petclinic.PETCLINIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.VET_SPECIALTIES_SPECIALTY_ID, Indexes.VET_SPECIALTIES_VET_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<VetSpecialtiesRecord>> getKeys() {
        return Arrays.<UniqueKey<VetSpecialtiesRecord>>asList(Keys.KEY_VET_SPECIALTIES_VET_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<VetSpecialtiesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<VetSpecialtiesRecord, ?>>asList(Keys.VET_SPECIALTIES_IBFK_1, Keys.VET_SPECIALTIES_IBFK_2);
    }

    public Vets vets() {
        return new Vets(this, Keys.VET_SPECIALTIES_IBFK_1);
    }

    public Specialties specialties() {
        return new Specialties(this, Keys.VET_SPECIALTIES_IBFK_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VetSpecialties as(String alias) {
        return new VetSpecialties(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VetSpecialties as(Name alias) {
        return new VetSpecialties(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VetSpecialties rename(String name) {
        return new VetSpecialties(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public VetSpecialties rename(Name name) {
        return new VetSpecialties(name, null);
    }
}
