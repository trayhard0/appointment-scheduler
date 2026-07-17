package io.github.trayhard0.appointmentscheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a stylist/service provider in the appointment scheduling system.
 * <p>
 * A stylist manages their own set of skillsets or {@link Offering}s, referred
 * to as specialties. Stylists can be toggled active or inactive depending on
 * their employment status or availability.
 * </p>
 *
 * @author trayhard0
 */
@Entity
public class Stylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    /**
     * The stylist's email address.
     * Enforced as unique in the database to prevent duplicate system profiles.
     */
    @NotBlank(message = "Email is required")
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Indicates whether the stylist is currently active.
     * Inactive stylists are preserved for historical scheduling records but
     * should not be allowed to accept new bookings.
     */
    @NotNull
    private boolean isActive = true;

    /**
     * The set of service offerings this stylist is specialized/qualified to perform.
     * <p>
     * This is the owning side of the Many-to-Many relationship. It configures
     * the join table {@code stylist_offerings} in the database.
     * </p>
     */
    @ManyToMany
    @JoinTable(
            name = "stylist_offerings",
            joinColumns = @JoinColumn(name = "stylist_id"),
            inverseJoinColumns = @JoinColumn(name = "offering_id")
    )
    private Set<Offering> specialties = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Offering> getSpecialties() {
        return specialties;
    }

    /**
     * Synchronizes the bidirectional Many-to-Many relationship by adding a
     * new specialty to this stylist.
     * Ensures that the inverse side of the relationship (the offering) also
     * references this stylist in memory.
     *
     * @param offering the service offering to add to this stylist's specialties
     */
    public void addSpecialty(Offering offering) {
        this.specialties.add(offering);
        offering.getStylists().add(this);
    }
}
