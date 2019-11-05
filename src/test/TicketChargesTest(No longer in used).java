/*
package test;

import controller.DBController;
import model.movie.Movie;
import model.transaction.Ticket;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


import static model.cinema.CinemaType.STANDARD;
import static model.movie.MovieEnums.MovieType.DIGITAL;
import static model.movie.MovieEnums.MovieType.THREE_DIMENSION;
import static service.TicketPriceService.getBasePrice;


public class TicketChargesTest {
    private static Ticket t;

    public static void main(String[] args) throws IOException, ParseException {
        DBController DB = new DBController();
        ArrayList<String> cast = new ArrayList<String>();
        Movie movie = new Movie("IRON MAN", "Jon Favreau", cast, "-");

     */
/*   DB.createNewDB("test1DB");
        List list = new ArrayList();
        for (MovieType m : MovieType.values()){
            list.add(m.getTicketPrice());
        }
        DB.updateDataDB(list, "test1DB");

        List movieTypeList = DB.readDB("test1DB");
        int i = 0;
        for (MovieType m : MovieType.values()) {
            System.out.println(movieTypeList.get(i));// Test Only (Will be Removed!)
            m.setTicketPrice((double) movieTypeList.get(i));
            i++;
        }*//*

        ticketPriceMenu();
        Ticket ticket = new Ticket(movie, THREE_DIMENSION, STANDARD);
        Scanner in = new Scanner(System.in);
        System.out.print("Please input a date (e.g. DD/MM/YYYY): ");
        String Date = in.next();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(Date, dateFormat);
       // System.out.println(isWeekend(date));
        //System.out.println(ticket.getTicketCharges(DIGITAL, STANDARD, isHoliday(date), isWeekend(date)));

    }

    public static void ticketPriceMenu() throws ParseException {
        while (true) {
            System.out.print("\n");
            System.out.print("====================================================================\n" +
                    "                      Configure System Setting                      \n" +
                    "====================================================================\n" +
                    "(1) Set Base Price (Current Base Price: " + String.format("%.2f", getBasePrice()) + ")\n" +
                    "(2) Movie Type Charges\n" +
                    "(3) Cinema Type Charges\n" +
                    "(4) Public Holiday/ Weekend Settings\n" +
                    "(5) Back\n" +
                    "====================================================================\n");
            try {
                System.out.print("Option: ");
                Scanner in = new Scanner(System.in);
                int opt = in.nextInt();
                if (opt == 1) {
                    System.out.print("Please input a base price: ");
                    double price = in.nextDouble();
                    setBasePrice(price);
                } else if (opt == 2) {
                    System.out.print("\n");
                    movieTypeCharges();
                } else if (opt == 3) {
                    System.out.print("\n");
                    cinemaTypeCharges();
                } else if (opt == 4) {
                    publicHolidaySettings();
                } else if (opt == 5) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("[System: Invalid Input]");
            }
        }
    }
}
*/
