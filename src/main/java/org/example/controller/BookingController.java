package org.example.controller;

import org.example.dto.CreateBookingRequest;
import org.example.entity.Booking;
import org.example.entity.User;
import org.example.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private BookingService bookingService;

//    POST /booking — создать бронирование (с выбором или автоподбором комнаты) (USER).
//    В теле запроса параметр autoSelect: true/false (при true поле roomId игнорируется).

    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingRequest request) {
        Booking booking = bookingService.createBooking(request);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Booking>> getUserBookings() {
        Long userId = 0L;
        List<Booking> bookings = bookingService.getBookingsForUserId(userId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.getById(id);
        return booking
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        bookingService.cancel(id);
        return ResponseEntity.ok("Бронирование отменено");
    }
}

