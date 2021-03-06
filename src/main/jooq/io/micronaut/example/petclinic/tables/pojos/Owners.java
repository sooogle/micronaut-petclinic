/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Owners implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private String        firstName;
    private String        lastName;
    private String        address;
    private String        city;
    private String        telephone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Owners() {}

    public Owners(Owners value) {
        this.id = value.id;
        this.firstName = value.firstName;
        this.lastName = value.lastName;
        this.address = value.address;
        this.city = value.city;
        this.telephone = value.telephone;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Owners(
        Integer       id,
        String        firstName,
        String        lastName,
        String        address,
        String        city,
        String        telephone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for <code>public.owners.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.owners.id</code>.
     */
    public Owners setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.owners.first_name</code>.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for <code>public.owners.first_name</code>.
     */
    public Owners setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Getter for <code>public.owners.last_name</code>.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for <code>public.owners.last_name</code>.
     */
    public Owners setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Getter for <code>public.owners.address</code>.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Setter for <code>public.owners.address</code>.
     */
    public Owners setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Getter for <code>public.owners.city</code>.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Setter for <code>public.owners.city</code>.
     */
    public Owners setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Getter for <code>public.owners.telephone</code>.
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * Setter for <code>public.owners.telephone</code>.
     */
    public Owners setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    /**
     * Getter for <code>public.owners.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.owners.created_at</code>.
     */
    public Owners setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.owners.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>public.owners.updated_at</code>.
     */
    public Owners setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Owners (");

        sb.append(id);
        sb.append(", ").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(address);
        sb.append(", ").append(city);
        sb.append(", ").append(telephone);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
