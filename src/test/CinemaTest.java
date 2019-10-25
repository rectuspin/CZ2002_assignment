package test;

import model.account.Admin;
import model.cinema.Cinema;
import model.cinema.CinemaType;
import model.cinema.Cineplex;
import model.cinema.Seat;
import service.AdminCineplexService;
import service.MovieGoerCineplexService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class CinemaTest {
    public static void main(String[] args) {
        Admin kane = new Admin("Kane", "Wu");
        AdminCineplexService adminCineplexService = new AdminCineplexService(kane);

        MovieGoerCineplexService movieGoerCineplexService = new MovieGoerCineplexService();

        ArrayList<Cineplex> cineplexArrayList = new ArrayList<>();
        cineplexArrayList.add(new Cineplex("Cathay JE"));
        cineplexArrayList.add(new Cineplex("Cathay Orchard"));
        cineplexArrayList.add(new Cineplex("Cathay Lido"));

        ArrayList<Cinema> cinemaArrayList = new ArrayList<>();
        cinemaArrayList.add(new Cinema("Hall 1"));
        cinemaArrayList.add(new Cinema("Hall 2"));
        cinemaArrayList.add(new Cinema("Hall 3", 'M', 20, CinemaType.IMAX));
        cinemaArrayList.add(new Cinema("Hall 4", 'N', 40, CinemaType.PLATINUM_MOVIE_SUITES));


        for (Cineplex cineplex : cineplexArrayList) {
            adminCineplexService.addCineplex(cineplex);
            for (Cinema cinema : cinemaArrayList) {
                adminCineplexService.addCinema(cineplex, cinema);
            }
        }
//        ArrayList<String> cast = new ArrayList<>();
//        cast.add("Tom");
//        cast.add("Dick");
//        cast.add("Harry");
//        Movie movie = new Movie("Batman Begins", "Christopher Nolan", cast, "The Batman");
//        adminCineplexService.addShowTime(movie, LocalDate.now(), LocalTime.of(11,30),  );

        HashMap<String, Cineplex> cineplexes = adminCineplexService.getCineplexes();
        Set<String> cineplexNames = cineplexes.keySet();
        for (String name : cineplexNames) {
            System.out.println(name + ": ");
            Cineplex cineplex = cineplexes.get(name);
            for (Cinema cinema : cineplex.getCinemas()) {
                System.out.println(cinema);
                HashMap<Character, Seat[]> cinemaLayout = cinema.getCinemaLayout();
                for (char row = 'A'; row <= cinema.getMaxRow(); row++) {
                    for (int col = 0; col < cinema.getMaxCol(); col++) {
                        System.out.print(cinemaLayout.get(row)[col]);
                    }
                    System.out.println();
                }
            }
        }


    }
}
