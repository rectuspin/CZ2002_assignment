package view;

import model.cinema.CinemaType;
import model.movie.MovieEnums;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import static service.TicketPriceService.*;
import static view.TicketPriceMenuView.*;


public class TicketPriceView {

    //This is the main control view
    public static void ticketPriceView() throws ParseException {
        while (true) {
            TicketPriceMenuView.systemConfigurationMenu();
            try {
                System.out.print("Option: ");
                Scanner in = new Scanner(System.in);
                int opt = in.nextInt();
                if (opt == 1){
                    System.out.print("Please input a base price: ");
                    double price = in.nextDouble();
                    setBasePrice(price);
                }
                else if (opt == 2) {
                    System.out.print("\n");
                    movieTypeSettings();
                } else if (opt == 3) {
                    System.out.print("\n");
                    cinemaTypeSettings();
                } else if (opt == 4) {
                    publicHolidaySettings();
                } else if (opt == 5) {
                    return;
                }
            }catch (Exception e){
                System.out.println("[System: Invalid Input]");
            }
        }
    }

    //Movie Type Settings
    //Settings function for different movie type charges
    public static void movieTypeSettings(){
        while (true) {
            movieTypeChargesMenu();   //Display each movie type to set additional charges
            Scanner in = new Scanner(System.in);
            System.out.print("Option: ");
            int opt = in.nextInt();   //Select an option of which movie type to be selected
            if (0 < opt && opt <= MovieEnums.MovieType.values().length) {
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();   //Input the amount for the extra charges
                setMovieTypeCharges(opt, charges);   //Sets the charges for each movie type
                System.out.println("[System: Movie Type Charges Set Successfully]");
            }
            else if (opt == MovieEnums.MovieType.values().length+1){
                return;
            }
            else{
                System.out.println("[System: Invalid Input]");
            }
        }
    }

    //Cinema Type Settings
    //Settings function for different cinema type charges
    public static void cinemaTypeSettings(){
        while (true) {
            cinemaTypeChargesMenu();   //Display each cinema type to set additional charges
            Scanner in = new Scanner(System.in);
            System.out.print("Option: ");
            int opt = in.nextInt();   //Select an option of which cinema type to be selected
            if (0 < opt && opt <= CinemaType.values().length) {
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();   //Input the amount for the extra charges
                setCinemaTypeCharges(opt, charges);   //Sets the charges for each cinema type
                System.out.println("[System: Cinema Type Charges Set Successfully]");
            }
            else if (opt == CinemaType.values().length+1){
                return;
            }
            else{
                System.out.println("[System: Invalid Input]");
            }
        }
    }

    //Public Holiday Settings
    //Settings function for adding public holiday dates
    public static void publicHolidaySettings() throws ParseException {
        Scanner in = new Scanner(System.in);
        int opt;
        while (true){
            publicHolidayMenu();   //Display the public holiday settings menu
            System.out.print("Option: ");
            opt = in.nextInt();   //Takes an input from user of selected option
            if (opt == 1){
                TicketPriceMenuView.publicHolidayList(true);
            }
            else if (opt == 2){
                //Takes date as a string input
                try {
                    System.out.print("Please input a date to add(e.g. DD/MM/YYYY): ");
                    String Date = in.next();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(Date, dateFormat);            //Adds the date into the array for reference
                    if (addPublicHolidayDates(date)){
                        System.out.println("[System: Public Holiday has been added!]");
                    }else{
                        System.out.println("[System: Duplicated Date detected!]");
                    }
                    TicketPriceMenuView.publicHolidayList(true);
                }catch (Exception e){
                    System.out.println("[System: Invalid Input]");
                }
            }
            else if (opt == 3){
                try {
                    TicketPriceMenuView.publicHolidayList(false);
                    System.out.print("Please input a date to remove (e.g. DD/MM/YYYY): ");
                    String Date = in.next();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(Date, dateFormat);            //Adds the date into the array for reference
                    if (removePublicHolidayDates(date)){
                        System.out.println("[System: Public Holiday has been removed!]");
                    }else{
                        System.out.println("[System: Date not found!]");
                    }
                    TicketPriceMenuView.publicHolidayList(true);
                }catch (Exception e){
                    System.out.println("[System: Invalid Input]");
                }
            }
            else if (opt == 4){
                System.out.println("Current Charges Amount: " + String.format("%.2f", getPublicHolidayCharges()));
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();
                setPublicHolidayCharges(charges);
                System.out.println("[System: Public Holiday Charges Set Successfully]");
            }
            else if (opt == 5){
                System.out.println("Current Charges Amount: " + String.format("%.2f", getWeekendCharges()));
                System.out.print("Extra Charges Amount: ");
                double charges = in.nextDouble();
                setWeekendCharges(charges);
                System.out.println("[System: Weekend Charges Set Successfully]");
            }
            else if (opt == 6){
                return;   //Goes to previous page
            }
        }
    }
}
