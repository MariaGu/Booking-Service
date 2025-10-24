package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CreateBookingRequest;
import org.example.entity.Booking;
import org.example.model.BookingStatus;
import org.example.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;

    public Optional<Booking> getById(Long id) {
        return bookingRepository.findById(id);
    }

    public void cancel(Long id) {
        bookingRepository.updateStatus(id, BookingStatus.CANCELLED);
    }

    public Booking createBooking(CreateBookingRequest createBookingRequest) {
//        доделай!!!
        Booking booking = new Booking();
        if (createBookingRequest.autoSelect) {
        } else {
        }
        return booking;
    }

    public List<Booking> getBookingsForUserId(Long id) {
        return bookingRepository.findByUserId(id);
    }


}
//Booking Service выполняет локальную транзакцию: создаёт бронирование в статусе PENDING
//и фиксирует его в своей базе данных.
//Booking Service вызывает Hotel Management Service для подтверждения доступности номера.
//При успешном ответе бронирование переводится в статус CONFIRMED. При ошибке или истечении
//времени ожидания выполняется компенсация: бронирование переводится в статус CANCELLED, временная
//блокировка слота в Hotel Service снимается (через эндпойнт POST /api/rooms/{id}/release),
//если на этапе подтверждения доступности была установлена блокировка.
