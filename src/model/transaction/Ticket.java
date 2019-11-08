package model.transaction;

import model.AgeGroup;
import model.Model;
import model.cinema.CinemaType;
import model.movie.Movie;
import model.movie.MovieEnums;
import service.TicketPriceService;

import static service.TicketPriceService.getBasePrice;


public class Ticket implements Model {
    private Movie movie;
    private MovieEnums.MovieType movieType;
    private CinemaType cinemaType;
    private AgeGroup ageGroup;
    private double basePrice;

    public Ticket(Movie movie, MovieEnums.MovieType movieType, CinemaType cinemaType) {
        this.movie = movie;
        this.movieType = movieType;
        this.cinemaType = cinemaType;
        this.basePrice = getBasePrice();
        this.ageGroup = ageGroup.STANDARD;
    }

    public double getTicketCharges(boolean isHoliday, boolean isWeekend) {
        double ticketPrice = basePrice;
        ticketPrice += cinemaType.getTicketPrice();
        ticketPrice += movieType.getTicketPrice();
        ticketPrice -= ageGroup.getTicketPrice();
        if (isHoliday) {
            ticketPrice += TicketPriceService.getPublicHolidayCharges();
        } else if (isWeekend) {
            ticketPrice += TicketPriceService.getWeekendCharges();
        }
        return ticketPrice;
    }

    public void setAgeGroup(AgeGroup ageGroup){
        this.ageGroup = ageGroup;
    }

    public Movie getMovie() {
        return movie;
    }

    public MovieEnums.MovieType getMovieType() {
        return movieType;
    }

    public CinemaType getCinemaType() {
        return cinemaType;
    }
}
