/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables.pojos;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Visits implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private Integer       petId;
    private LocalDate     visitDate;
    private String        description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Visits() {}

    public Visits(Visits value) {
        this.id = value.id;
        this.petId = value.petId;
        this.visitDate = value.visitDate;
        this.description = value.description;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Visits(
        Integer       id,
        Integer       petId,
        LocalDate     visitDate,
        String        description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for <code>public.visits.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.visits.id</code>.
     */
    public Visits setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.visits.pet_id</code>.
     */
    public Integer getPetId() {
        return this.petId;
    }

    /**
     * Setter for <code>public.visits.pet_id</code>.
     */
    public Visits setPetId(Integer petId) {
        this.petId = petId;
        return this;
    }

    /**
     * Getter for <code>public.visits.visit_date</code>.
     */
    public LocalDate getVisitDate() {
        return this.visitDate;
    }

    /**
     * Setter for <code>public.visits.visit_date</code>.
     */
    public Visits setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
        return this;
    }

    /**
     * Getter for <code>public.visits.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.visits.description</code>.
     */
    public Visits setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>public.visits.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.visits.created_at</code>.
     */
    public Visits setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.visits.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>public.visits.updated_at</code>.
     */
    public Visits setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Visits (");

        sb.append(id);
        sb.append(", ").append(petId);
        sb.append(", ").append(visitDate);
        sb.append(", ").append(description);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
