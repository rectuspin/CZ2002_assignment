package model.cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.UUID;

public class Cinema {
//    private static final Scanner scanner = new Scanner(System.in);

    private UUID uuid;

    private String name;

    private HashMap<Character, Seat[]> cinemaLayout;


    public Cinema(String name) {
        this.name = name;
        this.uuid = UUID.fromString(name);
        this.cinemaLayout = CinemaLayoutFactory.getCinemaLayout(this);
    }

    public String getName() {
        return name;
    }


//    public void makeBooking(LocalDateTime localDateTime, String[] seats) {
//        if (seatingArrangement.get(localDateTime) == null) { addShowTime(localDateTime); }
//        ArrayList<BitSet> seatsAvailable = seatingArrangement.get(localDateTime);
//
//        for(String seat : seats) {
//            setSeat(seat, seatsAvailable);
//        }
//    }
//
//    public void cancelBooking(LocalDateTime localDateTime, String[] seats) {
//        ArrayList<BitSet> seatsAvailable = seatingArrangement.get(localDateTime);
//
//        for(String seat : seats) {
//            removeSeat(seat, seatsAvailable);
//        }
//    }

    public void printSeats(LocalDateTime localDateTime) {
        if (!seatingArrangement.containsKey(localDateTime)) {
            System.out.println("Sorry, there are no movies screened at this timing");
            return;
        }
        ArrayList<BitSet> seats = seatingArrangement.get(localDateTime);

        int i = 0;
        for (; i < (numSeatsEachRow / 2 + 1.5 * aisleLength) - 2; i++) {
            System.out.print("===");
        }
        System.out.print(" S C R E E N ");
        for (; i < (numSeatsEachRow + 3 * aisleLength - 3); i++) {
            System.out.print("===");
        }
        System.out.println();
        System.out.println();

        for (int k = numOfRows - 1; k >= 0; k--) {
            BitSet bitset = seats.get(k);
            char row = Character.toUpperCase((char) (k + (int) ('a')));
            System.out.print(row + "  ");
            for (int j = 0; j < aisleLength - 1; j++) {
                System.out.print("   ");
            }
            for (int j = 0; j < numSeatsEachRow / 2; j++) {
                if (bitset.get(j) == false) System.out.print("[ ]");
                else System.out.print("[X]");
            }
            for (int j = 0; j < aisleLength; j++) {
                System.out.print("   ");
            }
            for (int j = numSeatsEachRow / 2; j < numSeatsEachRow; j++) {
                if (bitset.get(j) == false) System.out.print("[ ]");
                else System.out.print("[X]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        int k = 0;
        for (; k < (numSeatsEachRow + 3 * aisleLength) / 2 - 3; k++) {
            System.out.print("   ");
        }

        System.out.println("| E N T R A N C E |");
        System.out.print("\n\n");

    }


    private void setSeat(String seatLocation, ArrayList<BitSet> seatsAvailable) {
        char[] seat = seatLocation.toCharArray();
        int row = ((int) ((Character.toLowerCase(seat[0]))) - ((int) ('a')));

        int column = Character.getNumericValue(seat[1]);
        System.out.println("row: " + row + " column: " + column);
        seatsAvailable.get(row).set(column - 1);
    }

    private void cancelSeat(String seatLocation, ArrayList<BitSet> seatsAvailable) {
        char[] seat = seatLocation.toCharArray();
        int row = ((int) ((Character.toLowerCase(seat[0]))) - ((int) ('a')));

        int column = Character.getNumericValue(seat[1]);
        System.out.println("row: " + row + " column: " + column);
        seatsAvailable.get(row).clear(column - 1);
    }

    public void createCinemaLayout() {
        this.cinemaLayout = CinemaLayoutFactory.getCinemaLayout(this);
    }

    public void createCinemaLayout(char maxRow, int maxCol) {
        this.cinemaLayout = CinemaLayoutFactory.getCinemaLayout(this, maxRow, maxCol);
    }

}
