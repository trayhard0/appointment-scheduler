package io.github.trayhard0.appointmentscheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer/client in the appointment scheduling system.
 * <p>
 * This entity maintains the client's contact information and their complete
 * history of {@link Appointment} bookings. The email address serves as a unique
 * identifier at both the database level and application level.
 * </p>
 *
 * @author trayhard0
 */
@Entity
public class Client {
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
     * The client's unique email address.
     * Validated as a proper email format and enforced as unique in the database.
     */
    @NotBlank(message = "Email is required")
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 15, message = "Phone number must not exceed 15 characters")
    private String phoneNumber;

    /**
     * Bidirectional relationship tracking all appointments scheduled by this client.
     * <p>
     * {@code CascadeType.ALL} is applied here so that deleting or updating a Client
     * cascades directly to their associated appointments.
     * </p>
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Helper method to manage the bidirectional relationship safely.
     * Ensures both sides of the association are updated in memory.
     *
     * @param appointment the appointment to add
     */
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        appointment.setClient(this);
    }
}
