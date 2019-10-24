package model.transaction;

import model.cinema.Cineplex;

import java.time.LocalDate;
import java.util.HashMap;

public class CineplexBookings {
    private Cineplex cineplex;
    private HashMap<LocalDate, Booking> bookings;


    public CineplexBookings(Cineplex cineplex) {
        this.cineplex = cineplex;
        bookings = new HashMap<>();
    }

    public void makeBooking(LocalDate dateOfBooking, Booking booking) {
        bookings.put(dateOfBooking, booking);
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public HashMap<LocalDate, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(HashMap<LocalDate, Booking> bookings) {
        this.bookings = bookings;
    }
}
