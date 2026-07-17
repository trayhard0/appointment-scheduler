package io.github.trayhard0.appointmentscheduler.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

/**
 * Data Transfer Object (DTO) representing an incoming request to schedule a new appointment.
 * <p>
 * This object decouples the API payload from the internal database schema by transferring
 * flat, database-primary keys instead of complete entity objects.
 * </p>
 *
 * @author trayhard0
 */
public class AppointmentRequestDTO {

    /** The unique database identifier of the client booking the appointment. */
    @NotNull(message = "Client ID is required")
    private Long clientId;

    /** The unique database identifier of the stylist requested for the session. */
    @NotNull(message = "Stylist ID is required")
    private Long stylistId;

    /** The unique database identifier of the service offering selected. */
    @NotNull(message = "Offering ID is required")
    private Long offeringId;

    /**
     * The requested start time of the appointment in UTC.
     * <p>
     * Note: The end time is calculated on the server during payload processing
     * using the mapped {@code Offering} duration, rather than being supplied by the client.
     * </p>
     */
    @NotNull(message = "Start time is required")
    private Instant startTime;

    /** Optional notes or custom instructions provided by the client upon booking. */
    @Size(max = 1000, message = "Notes must not exceed 1000 characters")
    private String notes;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getStylistId() {
        return stylistId;
    }

    public void setStylistId(Long stylistId) {
        this.stylistId = stylistId;
    }

    public Long getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(Long offeringId) {
        this.offeringId = offeringId;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
