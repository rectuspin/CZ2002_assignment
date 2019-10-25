package model.cinema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Cineplex {
    private String name;
    private ArrayList<Cinema> cinemas;
    private HashMap<LocalDate, ArrayList<ShowTime>> showTimes;

    public Cineplex(String name) {
        this.name = name;
        this.cinemas = new ArrayList<>();
        this.showTimes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public HashMap<LocalDate, ArrayList<ShowTime>> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(HashMap<LocalDate, ArrayList<ShowTime>> showTimes) {
        this.showTimes = showTimes;
    }
}

