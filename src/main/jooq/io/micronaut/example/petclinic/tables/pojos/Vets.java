/*
 * This file is generated by jOOQ.
 */
package io.micronaut.example.petclinic.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Vets implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  firstName;
    private String  lastName;

    public Vets() {}

    public Vets(Vets value) {
        this.id = value.id;
        this.firstName = value.firstName;
        this.lastName = value.lastName;
    }

    public Vets(
        Integer id,
        String  firstName,
        String  lastName
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Getter for <code>public.vets.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.vets.id</code>.
     */
    public Vets setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.vets.first_name</code>.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter for <code>public.vets.first_name</code>.
     */
    public Vets setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Getter for <code>public.vets.last_name</code>.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter for <code>public.vets.last_name</code>.
     */
    public Vets setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vets (");

        sb.append(id);
        sb.append(", ").append(firstName);
        sb.append(", ").append(lastName);

        sb.append(")");
        return sb.toString();
    }
}
