package controller;

import model.cinema.CinemaType;
import model.movie.MovieEnums;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static controller.TicketPriceMenu.*;

public class TicketPriceController {

    private static ArrayList<LocalDate> publicHolidayDates = new ArrayList<LocalDate>();
    private static double publicHolidayCharges;
    private static double weekendCharges;
    public static double basePrice;

    //Movie Type Settings
    //Settings function for different movie type charges
    public static void movieTypeCharges() {
        while (true) {
            //Display each movie type to set additional charges
            movieTypeChargesMenu();

            //Select an option of which movie type to be selected
            Scanner in = new Scanner(System.in);
            System.out.print("Option: ");
            int opt = in.nextInt();
            if (0 < opt && opt <= MovieEnums.MovieType.values().length) {
                //Input the amount for the extra charges
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();
                //Sets the charges for each movie type
                setMovieTypeCharges(opt, charges);
                System.out.println("[System: Movie Type Charges Set Successfully]");
            } else if (opt == MovieEnums.MovieType.values().length + 1) {
                return;
            } else {
                System.out.println("[System: Invalid Input]");
            }
        }
    }

    //Cinema Type Settings
    //Settings function for different cinema type charges
    public static void cinemaTypeCharges() {
        while (true) {
            //Display each cinema type to set additional charges
            cinemaTypeChargesMenu();

            //Select an option of which cinema type to be selected
            Scanner in = new Scanner(System.in);
            System.out.print("Option: ");
            int opt = in.nextInt();
            if (0 < opt && opt <= CinemaType.values().length) {
                //Input the amount for the extra charges
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();
                //Sets the charges for each cinema type
                setCinemaTypeCharges(opt, charges);
                System.out.println("[System: Cinema Type Charges Set Successfully]");
            } else if (opt == CinemaType.values().length + 1) {
                return;
            } else {
                System.out.println("[System: Invalid Input]");
            }
        }
    }

    //Public Holiday Settings
    //Settings function for adding public holiday dates
    public static void publicHolidaySettings() throws ParseException {
        Scanner in = new Scanner(System.in);
        int opt;
        while (true) {
            //Display the public holiday settings menu
            publicHolidayMenu();

            //Takes an input from user of selected option
            System.out.print("Option: ");
            opt = in.nextInt();
            if (opt == 1) {
                publicHolidayList();
            } else if (opt == 2) {
                //Takes date as a string input
                try {
                    System.out.print("Please input a date (e.g. DD/MM/YYYY): ");
                    String Date = in.next();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(Date, dateFormat);
                    //Adds the date into the array for reference
                    publicHolidayDates.add(date);
                    //Notify if date is added successfully
                    System.out.println("[System: Public Holiday has been added!]");
                    publicHolidayList();
                    System.out.println("[System: Public Holiday has been added!]");
                } catch (Exception e) {
                    System.out.println("[System: Invalid Input]");
                }
            } else if (opt == 3) {
                System.out.println("Current Charges Amount: " + String.format("%.2f", getPublicHolidayCharges()));
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();
                setPublicHolidayCharges(charges);
                System.out.println("[System: Public Holiday Charges Set Successfully]");
            } else if (opt == 4) {
                System.out.println("Current Charges Amount: " + String.format("%.2f", getWeekendCharges()));
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();
                setWeekendCharges(charges);
                System.out.println("[System: Weekend Charges Set Successfully]");
            } else if (opt == 5) {
                //Goes to previous page
                return;
            }
        }
    }

    //Public Holiday & Weekend Settings
    //Display all the public holidays in an interface
    public static void publicHolidayList() {
        System.out.print("\n");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy");

        System.out.print("====================================================================\n" +
                "                        Public Holiday Dates                        \n" +
                "====================================================================\n");
        if (publicHolidayDates.size() == 0) {
            System.out.println("There is no public holidays currently...");
        } else {
            for (LocalDate d : publicHolidayDates) {
                System.out.println(d.format(dateFormat));
            }
        }
        System.out.println("====================================================================\n" +
                "[1 Back]");
        if (backOption()) {
            return;
        }
    }

    //Sets the additional charges for a specified movie type
    public static void setMovieTypeCharges(int opt, double prices) {
        MovieEnums.MovieType.values()[opt - 1].setTicketPrice(prices);
    }

    //Sets the additional charges for a specified cinema type
    public static void setCinemaTypeCharges(int opt, double prices) {
        CinemaType.values()[opt - 1].setTicketPrice(prices);
    }

    public static void setPublicHolidayCharges(double charges) {
        publicHolidayCharges = charges;
    }

    public static double getPublicHolidayCharges() {
        return publicHolidayCharges;
    }

    public static void setWeekendCharges(double charges) {
        weekendCharges = charges;
    }

    public static double getWeekendCharges() {
        return weekendCharges;
    }

    public static void setBasePrice(double price) {
        basePrice = price;
    }

    public static double getBasePrice() {
        return basePrice;
    }

    //Checks if the selected day matches with given date
    public static boolean isWeekend(LocalDate date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E");
        return date.format(dateFormat).equals("Sun") || date.format(dateFormat).equals("Sat");
    }

    //Checks if the selected date matches with dates in publicHolidayDates array
    public static boolean isHoliday(LocalDate date) {
        for (LocalDate d : publicHolidayDates) {
            if (date.equals(d)) {
                return true;
            }
        }
        return false;
    }

    //Back option to allow user to go back to previous interface
    public static boolean backOption() {
        int opt;
        //Will keep asking user for an input until a valid option is selected
        while (true) {
            Scanner in = new Scanner(System.in);
            try {
                System.out.print("Option: ");
                opt = in.nextInt();
                if (opt == 1) {   //Goes back to the previous interface
                    return true;
                } else {
                    //Message appears if user input is invalid
                    System.out.println("[System: Invalid Input]");
                }
            } catch (Exception e) {
                //Message appears if user input is invalid
                System.out.println("[System: Invalid Input]");
            }
        }
    }
}
