package io.github.trayhard0.appointmentscheduler.service;

import io.github.trayhard0.appointmentscheduler.model.Booking;
import io.github.trayhard0.appointmentscheduler.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
