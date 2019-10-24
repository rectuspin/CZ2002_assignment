package service;

import model.cinema.Cinema;
import model.cinema.Cineplex;
import model.cinema.Seat;
import model.movie.Movie;
import model.transaction.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

public class CineplexService {

    private static CineplexService instance;

    private CineplexService() {
        instance = new CineplexService();
    }

    public void addShowTime() {

    }

    public void makeBooking(Cineplex cineplex, Cinema cinema, Movie movie, Seat[] seats, float price,
                            LocalDate dateOfBooking, LocalTime timeOfBooking, LocalDate dateOfMovie, LocalTime timeOfMovie) {

        Booking booking = new Booking(price, dateOfBooking, timeOfBooking, cineplex, cinema, movie, seats);
        if (cineplex.getShowTimes().containsKey(dateOfMovie)) {
            HashMap<LocalTime, HashMap<Cinema, Movie>> showTimes = cineplex.getShowTimes().get(dateOfMovie);
            if (showTimes.containsKey(timeOfMovie)) {
                HashMap<Cinema, Movie>
            }
        }

    }

    protected void addShowTime(LocalDateTime localDate, LocalTime localTime, Cineplex cineplex) {
        HashMap<LocalDate, HashMap<LocalTime, Cinema>> showTimes = cineplex.getShowTimes();
    }

    protected void removeShowTime(LocalDateTime localDateTime) {
        if (!seatingArrangement.containsKey(localDateTime)) {
            return;
        }

        seatingArrangement.remove(localDateTime);
    }


//    public void addCinema(Cinema cinema) { cinemas.put(cinema.getName(), cinema); }
//
//    public void addMovie(model.movie.Movie movie) { movies.add(movie); }

//    public void setMovieShowTime(Movie movie, Cinema cinema, LocalDateTime localDateTime) {
//            if(!movies.contains(movie)) {
//                System.out.println("Movie not in model.cinema!");
//            }
//            if(showTimes.containsKey(localDateTime)) {
//                HashMap<Cinema, Movie> cinemas = showTimes.get(localDateTime);
//                if(cinemas.containsKey(cinema)) {
//                    System.out.println("Slot is occupied! Remove current slot to set new showtime");
//                    return;
//                } else {
//                    cinemas.put(cinema, movie);
//                    cinema.addShowTime(localDateTime);
//                }
//            } else {
//                showTimes.put(localDateTime, new HashMap<Cinema, Movie>());
//                showTimes.get(localDateTime).put(cinema, movie);
//                cinema.addShowTime(localDateTime);
//            }
//    }
//
//    public void makeMovieBooking(Movie movie, Cinema cinema, LocalDateTime localDateTime, String[] seats) {
//        if(showTimes.containsKey(localDateTime)) {
//            HashMap<Cinema, Movie> cinemas = showTimes.get(localDateTime);
//            if(cinemas.containsValue(movie) && cinemas.containsKey(cinema)) {
//                cinema.makeBooking(localDateTime, seats);
//            } else {
//                System.out.println("This model.movie is not being played at this model.cinema at this timing! Please set the model.movie timing and the model.cinema it is being played at first. ");
//            }
//        }
//    }

//    public void setShowTimes(Movie movie, LocalDateTime localDateTime, Cinema cinema) {
//        if (showTimes.get(localDateTime)==null) {
//            showTimes.put(localDateTime, new HashMap<>());
//        }
//        HashMap shows = showTimes.get(localDateTime);
//        if(!shows.containsKey(movie)) { shows.put(movie, cinema); }
//        else { shows.replace(movie, shows.get(movie), movie); }
//    }
//
//    public Cinema getCinema(String cinemaName) { return cinemas.get(cinemaName); }


    public static CineplexService getInstance() {
        return (instance == null) ? instance : new CineplexService();
    }
}
