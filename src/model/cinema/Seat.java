package model.cinema;

public class Seat {

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
        return isOccupied ? "[ ]" : "[X]";
    }

    private boolean makeBooking() {
        if (!isOccupied) {
            isOccupied = true;
            return true;
        }
        return false;
    }

    private boolean cancelBooking() {
        if (isOccupied) {
            isOccupied = false;
            return true;
        }
        return false;
    }
}
