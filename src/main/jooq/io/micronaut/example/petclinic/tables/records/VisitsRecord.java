/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables.records;


import io.micronaut.example.petclinic.tables.Visits;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VisitsRecord extends UpdatableRecordImpl<VisitsRecord> implements Record6<Integer, Integer, LocalDate, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.visits.id</code>.
     */
    public VisitsRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.visits.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.visits.pet_id</code>.
     */
    public VisitsRecord setPetId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.visits.pet_id</code>.
     */
    public Integer getPetId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.visits.visit_date</code>.
     */
    public VisitsRecord setVisitDate(LocalDate value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.visits.visit_date</code>.
     */
    public LocalDate getVisitDate() {
        return (LocalDate) get(2);
    }

    /**
     * Setter for <code>public.visits.description</code>.
     */
    public VisitsRecord setDescription(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.visits.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.visits.created_at</code>.
     */
    public VisitsRecord setCreatedAt(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.visits.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.visits.updated_at</code>.
     */
    public VisitsRecord setUpdatedAt(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.visits.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, LocalDate, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Integer, LocalDate, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Visits.VISITS.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Visits.VISITS.PET_ID;
    }

    @Override
    public Field<LocalDate> field3() {
        return Visits.VISITS.VISIT_DATE;
    }

    @Override
    public Field<String> field4() {
        return Visits.VISITS.DESCRIPTION;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Visits.VISITS.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Visits.VISITS.UPDATED_AT;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getPetId();
    }

    @Override
    public LocalDate component3() {
        return getVisitDate();
    }

    @Override
    public String component4() {
        return getDescription();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdatedAt();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getPetId();
    }

    @Override
    public LocalDate value3() {
        return getVisitDate();
    }

    @Override
    public String value4() {
        return getDescription();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdatedAt();
    }

    @Override
    public VisitsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public VisitsRecord value2(Integer value) {
        setPetId(value);
        return this;
    }

    @Override
    public VisitsRecord value3(LocalDate value) {
        setVisitDate(value);
        return this;
    }

    @Override
    public VisitsRecord value4(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public VisitsRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public VisitsRecord value6(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public VisitsRecord values(Integer value1, Integer value2, LocalDate value3, String value4, LocalDateTime value5, LocalDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VisitsRecord
     */
    public VisitsRecord() {
        super(Visits.VISITS);
    }

    /**
     * Create a detached, initialised VisitsRecord
     */
    public VisitsRecord(Integer id, Integer petId, LocalDate visitDate, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Visits.VISITS);

        setId(id);
        setPetId(petId);
        setVisitDate(visitDate);
        setDescription(description);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }

    /**
     * Create a detached, initialised VisitsRecord
     */
    public VisitsRecord(io.micronaut.example.petclinic.tables.pojos.Visits value) {
        super(Visits.VISITS);

        if (value != null) {
            setId(value.getId());
            setPetId(value.getPetId());
            setVisitDate(value.getVisitDate());
            setDescription(value.getDescription());
            setCreatedAt(value.getCreatedAt());
            setUpdatedAt(value.getUpdatedAt());
        }
    }
}
