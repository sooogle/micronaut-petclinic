/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables;


import io.micronaut.example.petclinic.Indexes;
import io.micronaut.example.petclinic.Keys;
import io.micronaut.example.petclinic.Public;
import io.micronaut.example.petclinic.tables.records.PetsRecord;

import java.time.LocalDate;
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
public class Pets extends TableImpl<PetsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.pets</code>
     */
    public static final Pets PETS = new Pets();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PetsRecord> getRecordType() {
        return PetsRecord.class;
    }

    /**
     * The column <code>public.pets.id</code>.
     */
    public final TableField<PetsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.pets.name</code>.
     */
    public final TableField<PetsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>public.pets.birth_date</code>.
     */
    public final TableField<PetsRecord, LocalDate> BIRTH_DATE = createField(DSL.name("birth_date"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.pets.type_id</code>.
     */
    public final TableField<PetsRecord, Integer> TYPE_ID = createField(DSL.name("type_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.pets.owner_id</code>.
     */
    public final TableField<PetsRecord, Integer> OWNER_ID = createField(DSL.name("owner_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private Pets(Name alias, Table<PetsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Pets(Name alias, Table<PetsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.pets</code> table reference
     */
    public Pets(String alias) {
        this(DSL.name(alias), PETS);
    }

    /**
     * Create an aliased <code>public.pets</code> table reference
     */
    public Pets(Name alias) {
        this(alias, PETS);
    }

    /**
     * Create a <code>public.pets</code> table reference
     */
    public Pets() {
        this(DSL.name("pets"), null);
    }

    public <O extends Record> Pets(Table<O> child, ForeignKey<O, PetsRecord> key) {
        super(child, key, PETS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.PETS_NAME);
    }

    @Override
    public Identity<PetsRecord, Integer> getIdentity() {
        return (Identity<PetsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<PetsRecord> getPrimaryKey() {
        return Keys.PETS_PKEY;
    }

    @Override
    public List<ForeignKey<PetsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PETS__FK_PETS_TYPES, Keys.PETS__FK_PETS_OWNERS);
    }

    private transient Types _types_;
    private transient Owners _owners;

    public Types types_() {
        if (_types_ == null)
            _types_ = new Types(this, Keys.PETS__FK_PETS_TYPES);

        return _types_;
    }

    public Owners owners() {
        if (_owners == null)
            _owners = new Owners(this, Keys.PETS__FK_PETS_OWNERS);

        return _owners;
    }

    @Override
    public Pets as(String alias) {
        return new Pets(DSL.name(alias), this);
    }

    @Override
    public Pets as(Name alias) {
        return new Pets(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Pets rename(String name) {
        return new Pets(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Pets rename(Name name) {
        return new Pets(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, LocalDate, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
