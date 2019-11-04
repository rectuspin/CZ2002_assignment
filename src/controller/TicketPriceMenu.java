package controller;

import model.cinema.CinemaType;
import model.movie.MovieEnums;

import static controller.TicketPriceController.getPublicHolidayCharges;
import static controller.TicketPriceController.getWeekendCharges;

public class TicketPriceMenu {
    //Displays a menu for user to select which movie type charges they want to edit and set
    public static void movieTypeChargesMenu() {
        System.out.print("\n");
        System.out.print("====================================================================\n" +
                "                         Select Movie Type                         \n" +
                "====================================================================\n");
        int backNo = 0;
        for (int i = 0; i < MovieEnums.MovieType.values().length; i++) {
            System.out.println(i + 1 + ". " + MovieEnums.MovieType.values()[i] +
                    " (Current Charges: " + String.format("%.2f", MovieEnums.MovieType.values()[i].getTicketPrice()) + ")");
            backNo++;
        }
        System.out.println(backNo + 1 +
                ". Back\n====================================================================");
    }

    //Displays a menu for user to select which cinema type charges they want to edit and set
    public static void cinemaTypeChargesMenu() {
        System.out.print("\n");
        System.out.print("====================================================================\n" +
                "                         Select Cinema Type                         \n" +
                "====================================================================\n");
        int backNo = 0;
        for (int i = 0; i < CinemaType.values().length; i++) {
            System.out.println(i + 1 + ". " + CinemaType.values()[i] +
                    " (Current Charges: " + String.format("%.2f", CinemaType.values()[i].getTicketPrice()) + ")");
            backNo++;
        }
        System.out.println(+backNo + 1 +
                ". Back\n====================================================================");
    }

    //Display all the available public holidays settings in an interface
    public static void publicHolidayMenu() {
        System.out.print("\n");
        System.out.print("====================================================================\n" +
                "                  Public Holiday/ Weekend Settings                  \n" +
                "====================================================================\n" +
                "(1) List Public Holidays\n" +
                "(2) Add a Public Holiday\n" +
                "(3) Set Public Holiday Charges (Current Charges: SGD " +
                String.format("%.2f", getPublicHolidayCharges()) + ")\n" +
                "(4) Set Weekend Charges (Current Charges: SGD " +
                String.format("%.2f", getWeekendCharges()) + ")\n" +
                "(5) Back\n" +
                "====================================================================\n");
    }


}
