package service;

import model.cinema.Cineplex;
import model.cinema.Seat;
import model.cinema.ShowTime;
import model.movie.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MovieGoerCineplexService {

    // returns showtimes at a cineplex on a certain day
    public ArrayList<ShowTime> getShowTimes(Cineplex cineplex, LocalDate localDate) {
        return cineplex.getShowTimes().get(localDate);
    }

    // returns showtimes for a certain movie for the next 3 days
    public ArrayList<ShowTime> getShowTimes(Cineplex[] cineplexes, Movie movie) {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysLater = today.plusDays(3);
        ArrayList<ShowTime> nextThreeDays = new ArrayList<>();
        for (; !today.equals(threeDaysLater); today.plusDays(1)) {
            for (Cineplex cineplex : cineplexes) {
                ArrayList<ShowTime> showTimes = cineplex.getShowTimes().get(today);
                for (ShowTime showTime : showTimes) {
                    if (showTime.getMovie() == movie) {
                        nextThreeDays.add(showTime);
                    }
                }
            }
        }
        return nextThreeDays;
    }

    public void makeBooking(ShowTime showTime, String[] seatPos, String name) {
        HashMap<Character, Seat[]> layout = showTime.getSeatLayout();
        for (String seat : seatPos) {
            char row = Character.toUpperCase(seat.charAt(0));
            int col = seat.charAt(1);
            layout.get(row)[col - 1].makeBooking();
        }
    }

    public void cancelBooking(ShowTime showTime, String[] seatPos, String name) {
        HashMap<Character, Seat[]> layout = showTime.getSeatLayout();
        for (String seat : seatPos) {
            char row = Character.toUpperCase(seat.charAt(0));
            int col = seat.charAt(1);
            layout.get(row)[col - 1].cancelBooking();
        }
    }

    public void showAvailableSeats(ShowTime showTime) {
        HashMap<Character, Seat[]> layout = showTime.getSeatLayout();
        for (char row = 'A'; row <= 'J'; row++) {
            Seat[] seats = layout.get(row);
            for (int i = 0; i < seats.length; i++) {
                System.out.println(seats[i]);
            }
        }
    }
}
