package io.github.trayhard0.appointmentscheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

/**
 * Represents a scheduled appointment between a {@link Client} and a {@link Stylist}
 * for a specific service {@link Offering}.
 * <p>
 * This entity is mapped to the database and includes validations for appointment
 * times, status, and associated relationships.
 * </p>
 *
 * @author trayhard0
 */
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** The start time of the appointment is in UTC. */
    @NotNull(message = "Start time is required")
    private Instant startTime;

    /** The end time of the appointment in UTC. */
    @NotNull(message = "End time is required")
    private Instant endTime;

    /**
     * The current lifecycle state of the appointment
     * (e.g., "SCHEDULED", "COMPLETED", "CANCELLED").
     */
    @NotBlank(message = "Status is required")
    private String status;

    /** Optional notes or special instructions provided by the client or stylist. */
    @Size(max = 1000, message = "Notes must not exceed 1000 characters")
    private String notes;

    /** The client who booked the appointment. Lazy loaded for performance. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    /** The stylist assigned to perform the service. Lazy loaded. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stylist_id", nullable = false)
    private Stylist stylist;

    /** The specific service offering booked for this session. Lazy loaded. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offering_id", nullable = false)
    private Offering offering;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }
}
