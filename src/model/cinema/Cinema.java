package model.cinema;

import model.Model;

import java.util.HashMap;

public class Cinema implements Model {
//    private static final Scanner scanner = new Scanner(System.in);

//    private UUID uuid;

    private String name;

    private HashMap<Character, Seat[]> cinemaLayout;

    private CinemaType cinemaType;

    private char maxRow = 'J';

    private int maxCol = 16;

    public Cinema(String name) {
        this.name = name;
//        this.uuid = UUID.fromString(name);
        createCinemaLayout();
        this.cinemaType = CinemaType.STANDARD;
    }

    public Cinema(String name, char maxRow, int maxCol, CinemaType cinemaType) {
//        this.uuid = UUID.fromString(name);
        this.name = name;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        createCinemaLayout(maxRow, maxCol);
        this.cinemaType = cinemaType;
    }

    public String getName() {
        return name;
    }



    public void createCinemaLayout() {
        this.cinemaLayout = CinemaLayoutFactory.getCinemaLayout(this);
    }

    public void createCinemaLayout(char maxRow, int maxCol) {
        this.cinemaLayout = CinemaLayoutFactory.getCinemaLayout(this, maxRow, maxCol);
    }

    public HashMap<Character, Seat[]> copyCinemaLayout() {
        return (HashMap<Character, Seat[]>) (cinemaLayout.clone());
    }

    public HashMap<Character, Seat[]> getCinemaLayout() {
        return cinemaLayout;
    }

    public char getMaxRow() {
        return maxRow;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public CinemaType getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(CinemaType cinemaType) {
        this.cinemaType = cinemaType;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", cinemaLayout=" + cinemaLayout +
                ", cinemaType=" + cinemaType +
                '}';
    }
}
