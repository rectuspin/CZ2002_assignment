package model.transaction;

import model.account.Customer;
import model.cinema.Cinema;
import model.cinema.Cineplex;
import model.cinema.Seat;
import model.cinema.ShowTime;
import model.movie.Movie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static controller.TicketPriceController.isHoliday;
import static controller.TicketPriceController.isWeekend;

public class Booking {
    private double price;
    private String transactionID;
    private Customer customer;
    private LocalDate dateOfBooking;
    private LocalTime timeOfBooking;
    private ShowTime showTime;
    private Cineplex cineplex;
    private Cinema cinema;
    private Movie movie;
    private Seat[] seats;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    private float discount = 0;

    public Booking(LocalDate dateOfBooking, LocalTime timeOfBooking, ShowTime showTime, Seat[] seats, Customer customer) {
        this.dateOfBooking = dateOfBooking;
        this.timeOfBooking = timeOfBooking;
        this.showTime = showTime;
        this.seats = seats;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hhmm");
        this.transactionID = "CUS" + this.dateOfBooking.format(dateFormat) + this.timeOfBooking.format(timeFormat);
        this.customer = customer;
    }

    public void makeBooking() {
        tickets.add(new Ticket(movie, showTime.getMovieType(), cinema.getCinemaType()));
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public double getPrice(LocalDate date) {
        for (Ticket ticket : tickets) {
            price += ticket.getTicketCharges(showTime.getMovieType(), cinema.getCinemaType(), isHoliday(date), isWeekend(date));
        }
        return price;
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
