/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables;


import io.micronaut.example.petclinic.Indexes;
import io.micronaut.example.petclinic.Keys;
import io.micronaut.example.petclinic.Public;
import io.micronaut.example.petclinic.tables.records.SpecialtiesRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Specialties extends TableImpl<SpecialtiesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.specialties</code>
     */
    public static final Specialties SPECIALTIES = new Specialties();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SpecialtiesRecord> getRecordType() {
        return SpecialtiesRecord.class;
    }

    /**
     * The column <code>public.specialties.id</code>.
     */
    public final TableField<SpecialtiesRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.specialties.name</code>.
     */
    public final TableField<SpecialtiesRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(80), this, "");

    private Specialties(Name alias, Table<SpecialtiesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Specialties(Name alias, Table<SpecialtiesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.specialties</code> table reference
     */
    public Specialties(String alias) {
        this(DSL.name(alias), SPECIALTIES);
    }

    /**
     * Create an aliased <code>public.specialties</code> table reference
     */
    public Specialties(Name alias) {
        this(alias, SPECIALTIES);
    }

    /**
     * Create a <code>public.specialties</code> table reference
     */
    public Specialties() {
        this(DSL.name("specialties"), null);
    }

    public <O extends Record> Specialties(Table<O> child, ForeignKey<O, SpecialtiesRecord> key) {
        super(child, key, SPECIALTIES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.SPECIALTIES_NAME);
    }

    @Override
    public Identity<SpecialtiesRecord, Integer> getIdentity() {
        return (Identity<SpecialtiesRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<SpecialtiesRecord> getPrimaryKey() {
        return Keys.SPECIALTIES_PKEY;
    }

    @Override
    public Specialties as(String alias) {
        return new Specialties(DSL.name(alias), this);
    }

    @Override
    public Specialties as(Name alias) {
        return new Specialties(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Specialties rename(String name) {
        return new Specialties(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Specialties rename(Name name) {
        return new Specialties(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
