package controller;

import model.account.Admin;
import model.account.Customer;
import model.cinema.Cineplex;
import model.movie.Review;
import model.transaction.Booking;
import model.transaction.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SerializedDB implements Serializable {
    private HashMap<String, Cineplex> cineplexes;
    private ArrayList<Admin> admins;
    private ArrayList<Customer> customers;
    private ArrayList<Booking> bookings;

    public SerializedDB() {
        admins = new ArrayList<>();
        cineplexes = new HashMap<>();
        customers = new ArrayList<>();

        bookings = new ArrayList<>();
    }

    protected HashMap<String, Cineplex> getCineplexes() {
        return cineplexes;
    }

    protected void setCineplexes(HashMap<String, Cineplex> cineplexes) {
        this.cineplexes = cineplexes;
    }

    protected ArrayList<Admin> getAdmins() {
        return admins;
    }

    protected void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    protected ArrayList<Customer> getCustomers() {
        return customers;
    }

    protected void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    protected ArrayList<Ticket> getTickets() {
        return tickets;
    }

    protected void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    protected ArrayList<Review> getReviews() {
        return reviews;
    }

    protected void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    protected ArrayList<Booking> getBookings() {
        return bookings;
    }

    protected void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
