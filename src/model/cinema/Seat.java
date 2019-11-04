package model.cinema;

import model.Model;

public class Seat implements Model {

    private boolean isOccupied = false;
    private Cinema cinema;
    private char row;
    private int col;

    public Seat(Cinema cinema, char row, int col) {
        this.cinema = cinema;
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return isOccupied ? "[X]" : "[ ]";
    }

    public boolean makeBooking() {
        if (!isOccupied) {
            isOccupied = true;
            return true;
        }
        return false;
    }

    public boolean cancelBooking() {
        if (isOccupied) {
            isOccupied = false;
            return true;
        }
        return false;
    }
}
