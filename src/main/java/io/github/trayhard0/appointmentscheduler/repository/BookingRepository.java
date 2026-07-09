package io.github.trayhard0.appointmentscheduler.repository;

import io.github.trayhard0.appointmentscheduler.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
