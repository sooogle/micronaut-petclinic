/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables;


import io.micronaut.example.petclinic.Indexes;
import io.micronaut.example.petclinic.Keys;
import io.micronaut.example.petclinic.Public;
import io.micronaut.example.petclinic.tables.records.VetsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
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
public class Vets extends TableImpl<VetsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.vets</code>
     */
    public static final Vets VETS = new Vets();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VetsRecord> getRecordType() {
        return VetsRecord.class;
    }

    /**
     * The column <code>public.vets.id</code>.
     */
    public final TableField<VetsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.vets.first_name</code>.
     */
    public final TableField<VetsRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>public.vets.last_name</code>.
     */
    public final TableField<VetsRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>public.vets.created_at</code>.
     */
    public final TableField<VetsRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_DATE", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.vets.updated_at</code>.
     */
    public final TableField<VetsRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_DATE", SQLDataType.LOCALDATETIME)), this, "");

    private Vets(Name alias, Table<VetsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Vets(Name alias, Table<VetsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.vets</code> table reference
     */
    public Vets(String alias) {
        this(DSL.name(alias), VETS);
    }

    /**
     * Create an aliased <code>public.vets</code> table reference
     */
    public Vets(Name alias) {
        this(alias, VETS);
    }

    /**
     * Create a <code>public.vets</code> table reference
     */
    public Vets() {
        this(DSL.name("vets"), null);
    }

    public <O extends Record> Vets(Table<O> child, ForeignKey<O, VetsRecord> key) {
        super(child, key, VETS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.VETS_LAST_NAME);
    }

    @Override
    public Identity<VetsRecord, Integer> getIdentity() {
        return (Identity<VetsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<VetsRecord> getPrimaryKey() {
        return Keys.VETS_PKEY;
    }

    @Override
    public Vets as(String alias) {
        return new Vets(DSL.name(alias), this);
    }

    @Override
    public Vets as(Name alias) {
        return new Vets(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Vets rename(String name) {
        return new Vets(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Vets rename(Name name) {
        return new Vets(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
