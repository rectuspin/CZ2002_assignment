package model.transaction;

import model.AgeGroup;
import model.Model;
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

import static service.TicketPriceService.isHoliday;
import static service.TicketPriceService.isWeekend;


public class Booking implements Model {
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

    public Booking(LocalDate dateOfBooking, LocalTime timeOfBooking, ShowTime showTime, Seat[] seats, Customer customer) {
        this.dateOfBooking = dateOfBooking;
        this.timeOfBooking = timeOfBooking;
        this.showTime = showTime;
        this.seats = seats;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hhmm");
        this.transactionID = "CUS" + this.dateOfBooking.format(dateFormat) + this.timeOfBooking.format(timeFormat);
        this.customer = customer;
        this.movie = this.showTime.getMovie();
        this.cinema = this.showTime.getCinema();
        this.cineplex = this.showTime.getCineplex();
    }

    public void makeBooking() {
        tickets.add(new Ticket(movie, showTime.getMovieType(), cinema.getCinemaType()));
    }

    public void makeBooking(AgeGroup ageGroup) {
        Ticket ticket = new Ticket(movie, showTime.getMovieType(), cinema.getCinemaType());
        ticket.setAgeGroup(ageGroup);
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public double getPrice(LocalDate date) {
        price = 0;
        for (Ticket ticket : tickets) {
            price += ticket.getTicketCharges(isHoliday(date), isWeekend(date));
        }
        return price;
    }
    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public LocalTime getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(LocalTime timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
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

    public String getTransactionID(){return transactionID;}

}
