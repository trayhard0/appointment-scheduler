package io.github.trayhard0.appointmentscheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a specific service or treatment offered by the business.
 * <p>
 * An offering defines the standard duration and price for a service.
 * It is associated with one or more {@link Stylist}s who have the required
 * skills (specialties) to perform it.
 * </p>
 *
 * @author trayhard0
 */
@Entity
public class Offering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer durationMinutes;

    /**
     * The cost of the service.
     * <p>
     * {@link BigDecimal} is used instead of double/float to prevent rounding
     * errors during monetary calculations. The database column restricts this
     * to 10 total digits with 2 decimal places.
     * </p>
     */
    @NotNull(message = "Price is required")
    @Column(nullable = false, precision = 10, scale = 2)
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    /**
     * The set of stylists qualified to perform this offering.
     * This is the inverse (non-owning) side of the Many-to-Many relationship.
     */
    @ManyToMany(mappedBy = "specialties")
    private Set<Stylist> stylists = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Stylist> getStylists() {
        return stylists;
    }

    /**
     * Synchronizes the bidirectional Many-to-Many relationship between Offering and Stylist.
     * Ensures that when a stylist is added to this offering, this offering
     * is also correctly appended to the stylist's specialties in memory.
     *
     * @param stylist the stylist to associate with this offering
     */
    public void addStylist(Stylist stylist) {
        this.stylists.add(stylist);
        stylist.getSpecialties().add(this);
    }
}
