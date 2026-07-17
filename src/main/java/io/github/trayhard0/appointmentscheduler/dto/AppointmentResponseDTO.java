package io.github.trayhard0.appointmentscheduler.dto;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Data Transfer Object (DTO) representing a detailed appointment response payload sent to the client.
 * <p>
 * This DTO acts as a flattened read-only representation of the {@link io.github.trayhard0.appointmentscheduler.model.Appointment}
 * entity. It aggregates essential information from associated entities (Client, Stylist, and Offering)
 * to minimize the number of API roundtrips required by client-side UIs.
 * </p>
 *
 * @author trayhard0
 */
public class AppointmentResponseDTO {

    /** The unique database identifier for the appointment. */
    private Long id;

    /** The start time of the appointment in UTC. */
    private Instant startTime;

    /** The calculated end time of the appointment in UTC. */
    private Instant endTime;

    /** The current status of the appointment (e.g., "SCHEDULED", "COMPLETED"). */
    private String status;

    /** Optional notes or custom instructions provided during booking. */
    private String notes;

    // Client Details
    private Long clientId;
    private String clientFirstName;
    private String clientLastName;

    // Stylist Details
    private Long stylistId;
    private String stylistFirstName;
    private String stylistLastName;

    // Offering Details
    private Long offeringId;
    private String offeringName;

    /**
     * The cost of the service at the time of booking.
     * Stored as a high-precision decimal to ensure accurate billing displays on the UI.
     */
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public Long getStylistId() {
        return stylistId;
    }

    public void setStylistId(Long stylistId) {
        this.stylistId = stylistId;
    }

    public String getStylistFirstName() {
        return stylistFirstName;
    }

    public void setStylistFirstName(String stylistFirstName) {
        this.stylistFirstName = stylistFirstName;
    }

    public String getStylistLastName() {
        return stylistLastName;
    }

    public void setStylistLastName(String stylistLastName) {
        this.stylistLastName = stylistLastName;
    }

    public Long getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(Long offeringId) {
        this.offeringId = offeringId;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public void setOfferingName(String offeringName) {
        this.offeringName = offeringName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
