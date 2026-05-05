package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Booking;
import com.example.GlowUpAPI.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> getByCustomerId(Long customerId) {
        List<Booking> bookings = bookingRepository.findByCustomerId(customerId);

        bookings.forEach(b -> {
            if (b.getBeauty() != null) {
                b.getBeauty().getUserId(); // force load
            }
        });

        return bookings;
    }

    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
    
    public List<Booking> getByBeautyId(Long beautyId) {
        return bookingRepository.findByBeauty_UserId(beautyId);
    }

    public Booking confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

}
