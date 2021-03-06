/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables.records;


import io.micronaut.example.petclinic.tables.Types;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TypesRecord extends UpdatableRecordImpl<TypesRecord> implements Record4<Integer, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.types.id</code>.
     */
    public TypesRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.types.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.types.name</code>.
     */
    public TypesRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.types.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.types.created_at</code>.
     */
    public TypesRecord setCreatedAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.types.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.types.updated_at</code>.
     */
    public TypesRecord setUpdatedAt(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.types.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Types.TYPES.ID;
    }

    @Override
    public Field<String> field2() {
        return Types.TYPES.NAME;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Types.TYPES.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Types.TYPES.UPDATED_AT;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public LocalDateTime component3() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component4() {
        return getUpdatedAt();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public LocalDateTime value3() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value4() {
        return getUpdatedAt();
    }

    @Override
    public TypesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TypesRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public TypesRecord value3(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public TypesRecord value4(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public TypesRecord values(Integer value1, String value2, LocalDateTime value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TypesRecord
     */
    public TypesRecord() {
        super(Types.TYPES);
    }

    /**
     * Create a detached, initialised TypesRecord
     */
    public TypesRecord(Integer id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Types.TYPES);

        setId(id);
        setName(name);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }

    /**
     * Create a detached, initialised TypesRecord
     */
    public TypesRecord(io.micronaut.example.petclinic.tables.pojos.Types value) {
        super(Types.TYPES);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setCreatedAt(value.getCreatedAt());
            setUpdatedAt(value.getUpdatedAt());
        }
    }
}
