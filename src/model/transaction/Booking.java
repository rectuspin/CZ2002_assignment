package model.transaction;

import model.cinema.Cinema;
import model.cinema.Cineplex;
import model.cinema.Seat;
import model.movie.Movie;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private BigDecimal price;
    private LocalDate dateOfBooking;
    private LocalTime timeOfBooking;
    private Cineplex cineplex;
    private Cinema cinema;
    private Movie movie;
    private Seat[] seats;

    private float discount = 0;

    public Booking(float price, LocalDate dateOfBooking, LocalTime timeOfBooking, Cineplex cineplex, Cinema cinema, Movie movie, Seat[] seats) {
        this.price = BigDecimal.valueOf(price);
        this.dateOfBooking = dateOfBooking;
        this.timeOfBooking = timeOfBooking;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.movie = movie;
        this.seats = seats;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
