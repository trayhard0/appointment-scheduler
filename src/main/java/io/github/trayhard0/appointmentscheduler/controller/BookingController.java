package io.github.trayhard0.appointmentscheduler.controller;

import io.github.trayhard0.appointmentscheduler.model.Booking;
import io.github.trayhard0.appointmentscheduler.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public Booking createBooking(@Valid @RequestBody Booking newBooking) {
        newBooking.setCustomerFirstName(newBooking.getCustomerFirstName().trim());
        newBooking.setCustomerLastName(newBooking.getCustomerLastName().trim());
        return bookingService.saveBooking(newBooking);
    }
}
