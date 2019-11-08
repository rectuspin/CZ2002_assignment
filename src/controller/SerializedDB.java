package controller;

import model.account.Admin;
import model.account.Customer;
import model.cinema.Cineplex;
import model.movie.Movie;
import model.transaction.Booking;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class SerializedDB implements Serializable {
    private static SerializedDB serializedDB = null;
    private HashMap<String, Cineplex> cineplexes;
    private ArrayList<Movie> movies;
    private ArrayList<Admin> admins;
    private ArrayList<Customer> customers;
    private ArrayList<Booking> bookings;
    private ArrayList<LocalDate> publicHolidayDates;
    private HashMap<String, Integer> sales;
    private double publicHolidayCharges;
    private double weekendCharges;
    private double basePrice;


    public SerializedDB(){
        admins = new ArrayList<>();
        cineplexes = new HashMap<>();
        movies = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
        publicHolidayDates = new ArrayList<>();
        sales = new HashMap<>();
    }

    public HashMap<String, Cineplex> getCineplexes() {
        return cineplexes;
    }

    public ArrayList<Movie> getMovies(){ return movies;}

    protected void setCineplexes(HashMap<String, Cineplex> cineplexes) {
        this.cineplexes = cineplexes;
    }

    protected void addCineplexes(Cineplex cineplex){
        this.cineplexes.put(cineplex.getName(), cineplex);
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

    protected ArrayList<Booking> getBookings() {
        return bookings;
    }

    protected void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public double getPublicHolidayCharges(){ return publicHolidayCharges; }

    public double getWeekendCharges(){ return weekendCharges;}

    public double getBasePrice(){ return basePrice; }

    public ArrayList<LocalDate> getPublicHolidayDates(){ return publicHolidayDates; }

    public void setTicketPricing(ArrayList<LocalDate> publicHolidayDates, double publicHolidayCharges, double weekendCharges, double basePrice){
        this.publicHolidayCharges = publicHolidayCharges;
        this.publicHolidayDates = publicHolidayDates;
        this.weekendCharges = weekendCharges;
        this.basePrice = basePrice;
    }

    public static SerializedDB getInstance()
    {
        if (serializedDB == null)
            serializedDB = new SerializedDB();

        return serializedDB;
    }

    public void addSales(String movieName, int numOfTickets){
        sales.put(movieName, numOfTickets);
    }

    public HashMap<String, Integer> getSales(){
        return sales;
    }

    public Integer getSalesFigure(String movieName){
        return sales.get(movieName);
    }
}
