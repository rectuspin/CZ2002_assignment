package service;

import controller.DBController;
import model.account.Admin;
import model.cinema.Cinema;
import model.cinema.Cineplex;
import model.cinema.ShowTime;
import model.movie.Movie;
import model.movie.MovieEnums;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminCineplexService {
    private Admin admin;
    private DBController dbController = DBController.getInstance();


    public AdminCineplexService(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void addCineplex(Cineplex cineplex) {
//        dbController.getCineplexes().put(cineplex.getName(), cineplex);
        dbController.addCineplex(cineplex);
    }

    public void removeCineplex(String name) {
        dbController.removeCineplex(name);
    }

    public void addCinema(Cineplex cineplex, Cinema cinema) {
        dbController.addCinema(cineplex, cinema);
    }

    public void removeCinema(Cineplex cineplex, Cinema cinema) {
        dbController.removeCinema(cineplex, cinema);
    }

    public void addShowTime(Movie movie, LocalDate dateOfMovie, LocalTime timeOfMovie, Cinema cinema,
                            Cineplex cineplex) {

        ShowTime newShowTime = new ShowTime(movie, dateOfMovie, timeOfMovie, cinema.copyCinemaLayout(),
                cineplex, cinema);
        Admin.getCineplexes().get(cineplex.getName()).getShowTimes().get(dateOfMovie).add(newShowTime);

    }

    public void addShowTime(Movie movie, LocalDate dateOfMovie, LocalTime timeOfMovie, Cinema cinema,
                            Cineplex cineplex, MovieEnums.Language language, MovieEnums.Subtitle subtitle, MovieEnums.MovieType movieType) {

        ShowTime newShowTime = new ShowTime(movie, dateOfMovie, timeOfMovie, cinema.copyCinemaLayout(),
                cineplex, cinema, language, subtitle, movieType);


        Admin.getCineplexes().get(cineplex.getName()).getShowTimes().get(dateOfMovie).add(newShowTime);
    }

    public void removeShowTime(Movie movie, LocalDate dateOfMovie, LocalTime timeOfMovie, Cinema cinema,
                               Cineplex cineplex) {
        ArrayList<ShowTime> showTimes = Admin.getCineplexes().get(cineplex.getName()).getShowTimes().get(dateOfMovie);
        for (ShowTime showTime : showTimes) {
            if (showTime.getMovie() == movie && showTime.getTimeOfMovie() == timeOfMovie &&
                    showTime.getCinema() == cinema) {
                Admin.getCineplexes().get(cineplex.getName()).getShowTimes().get(dateOfMovie).remove(showTime);
            }
        }
    }

    public HashMap getCineplexes() {
        return Admin.getCineplexes();
    }


}
