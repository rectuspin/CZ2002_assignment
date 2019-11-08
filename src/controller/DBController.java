package controller;

import model.AgeGroup;
import model.cinema.Cinema;
import model.cinema.CinemaType;
import model.cinema.Cineplex;
import model.cinema.ShowTime;
import model.movie.Movie;
import model.movie.MovieEnums;
import model.transaction.Booking;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static service.TicketPriceService.*;
import static service.TicketPriceService.setWeekendCharges;

public class DBController {
    private SerializedDB serializedDB = SerializedDB.getInstance();
    private static DBController dbController = null;
    //Creates a new DB
    public void createDB(String DBName) throws IOException {
        String dir = "src/database/";
        File myFile = new File(dir +DBName + ".dat");
        myFile.createNewFile();
    }

    public void deleteDB(String DBName) throws IOException {
        String dir = "src/database/";
        File myFile = new File(dir + DBName + ".dat");
        myFile.delete();
    }

    //Updates the data with a given list
    public void updateDB(List list, String DBName) throws IOException {
        String dir = "src/database/";
        File myFile = new File(dir + DBName + ".dat");
        if(!myFile.exists()) {
            myFile.createNewFile();
        }else {
            SerializeDB.writeSerializedObject(dir + DBName + ".dat", list);
        }
    }

    //Gets the data from the DB
    public List readDB(String DBName) throws IOException {
        String dir = "src/database/";
        List list = new ArrayList();
        File myFile = new File(dir + DBName + ".dat");
        if(!myFile.exists()) {
            myFile.createNewFile();
        }else {
            list = SerializeDB.readSerializedObject(dir + DBName + ".dat");
        }
        return list;
    }


    public HashMap<String, Cineplex> getCineplexes() {
        return serializedDB.getCineplexes();
    }

    public void addCineplex(Cineplex cineplex){
        serializedDB.addCineplexes(cineplex);
    }

    public void removeCineplex(String name){
        HashMap<String, Cineplex> cineplexes = serializedDB.getCineplexes();
        cineplexes.remove(name);
        serializedDB.setCineplexes(cineplexes);
    }

    public void addCinema(Cineplex cineplex, Cinema cinema){
        HashMap<String, Cineplex> cineplexes = serializedDB.getCineplexes();
        Cineplex selected_cineplex = cineplexes.get(cineplex.getName());
        ArrayList<Cinema> cinema_list= selected_cineplex.getCinemas();
        cinema_list.add(cinema);
        cineplex.setCinemas(cinema_list);
        cineplexes.replace(cineplex.getName(), cineplex);
        serializedDB.setCineplexes(cineplexes);
    }

    public void removeCinema(Cineplex cineplex, Cinema cinema){
        HashMap<String, Cineplex> cineplexes = serializedDB.getCineplexes();
        Cineplex selected_cineplex = cineplexes.get(cineplex.getName());
        ArrayList<Cinema> cinema_list= selected_cineplex.getCinemas();
        cinema_list.remove(cinema);
        cineplex.setCinemas(cinema_list);
        cineplexes.replace(cineplex.getName(), cineplex);
        serializedDB.setCineplexes(cineplexes);
    }

    public void addShowTimes(Cineplex cineplex, LocalDate dateOfMovie, ShowTime newShowTime){
        serializedDB.getCineplexes().get(cineplex.getName()).getShowTimes().get(dateOfMovie).add(newShowTime);
    }

    public void removeShowTimes(Movie movie, LocalDate dateOfMovie, LocalTime timeOfMovie, Cinema cinema,
                                Cineplex cineplex){
        ArrayList<ShowTime> showTimes = serializedDB.getCineplexes().get(cineplex.getName()).getShowTimes().get(dateOfMovie);
        for (ShowTime showTime : showTimes) {
            if (showTime.getMovie() == movie && showTime.getTimeOfMovie() == timeOfMovie &&
                    showTime.getCinema() == cinema) {
                serializedDB.getCineplexes().get(cineplex.getName()).getShowTimes().get(dateOfMovie).remove(showTime);
            }
        }
    }

    public static DBController getInstance()
    {
        if (dbController == null)
            dbController = new DBController();

        return dbController;
    }


    public void loadTicketPriceInfoDatabase() throws ParseException, IOException {
        DBController dbController = DBController.getInstance();
        List priceInfo = dbController.readDB("TicketPriceInfoDB");
        SerializedDB ticketInfo = (SerializedDB) priceInfo.get(0);

        //Loads all the prices and holiday dates into the application
        setBasePrice(ticketInfo.getBasePrice());
        setPublicHolidayCharges(ticketInfo.getPublicHolidayCharges());
        setPublicHolidayDates(ticketInfo.getPublicHolidayDates());
        setWeekendCharges(ticketInfo.getWeekendCharges());

        //Loads all the movie type prices and information into the application
        List movieType = dbController.readDB("MovieTypePriceDB");
        int i = 0;
        for (MovieEnums.MovieType m : MovieEnums.MovieType.values()) {
            m.setTicketPrice((double) movieType.get(i));
            i++;
        }

        //Loads all the cinema type prices and information into the application
        List cinemaType = dbController.readDB("CinemaTypePriceDB");
        i = 0;
        for (CinemaType c : CinemaType.values()) {
            c.setTicketPrice((double) cinemaType.get(i));
            i++;
        }

        //Loads all the cinema type prices and information into the application
        List ageGroup = dbController.readDB("ageGroupDiscountPriceDB");
        i = 0;
        for (AgeGroup group : AgeGroup.values()) {
            group.setTicketPrice((double) ageGroup.get(i));
            i++;
        }

    }

    public void saveTicketPriceInfoDatabase() throws IOException {
        DBController dbController = DBController.getInstance();
        //Saves all the base/holiday/weekend pricing and holiday dates into the database
        SerializedDB n = new SerializedDB();
        n.setTicketPricing(getPublicHolidayDates(), getPublicHolidayCharges(), getWeekendCharges(), getBasePrice());
        List ticketPrice = new ArrayList();
        ticketPrice.add(n);
        dbController.updateDB(ticketPrice, "TicketPriceInfoDB");

        //Saves all the different movie type pricing into the database
        List movieType = new ArrayList();
        for (MovieEnums.MovieType m : MovieEnums.MovieType.values()){
            movieType.add(m.getTicketPrice());
        }
        dbController.updateDB(movieType, "MovieTypePriceDB");

        //Saves all the different cinema type pricing into the database
        List cinemaType = new ArrayList();
        for (CinemaType c : CinemaType.values()){
            cinemaType.add(c.getTicketPrice());
        }
        dbController.updateDB(cinemaType, "CinemaTypePriceDB");

        //Saves all the different cinema type pricing into the database
        List ageGroup = new ArrayList();
        for (AgeGroup group : AgeGroup.values()){
            ageGroup.add(group.getTicketPrice());
        }
        dbController.updateDB(ageGroup, "ageGroupDiscountPriceDB");
    }

    public void addSales(Booking booking){
        serializedDB.addSales(booking.getMovie().getTitle(), booking.getTickets().size());
    }

    public HashMap<String, Integer> getSales(){
        return serializedDB.getSales();
    }

    public Integer getSalesFigure(String movieName){
        return serializedDB.getSalesFigure(movieName);
    }
}



