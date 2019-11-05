package view;

import model.cinema.CinemaType;
import model.movie.MovieEnums;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static service.TicketPriceService.*;

public class TicketPriceMenuView {
    //Here consist of all the sub menus views and holiday list interface for the system configuration settings
    //Display all the public holidays in an interface
    public static void publicHolidayList(boolean isBack){
        System.out.print("\n");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy");

        System.out.print(   "====================================================================\n"+
                            "                        Public Holiday Dates                        \n"+
                            "====================================================================\n");
        if (getPublicHolidayDates().size()== 0){
            System.out.println("There is no public holidays currently...");
        }else {
            for (LocalDate d : getPublicHolidayDates()) {
                System.out.println(d.format(dateFormat));
            }
        }
        System.out.println( "====================================================================");
        if(isBack) {
            System.out.println("[1 Back]");
            if (backOption()) {
                return;
            }
        }
    }


    //Displays a menu for user to select which movie type charges they want to edit and set
    public static void movieTypeChargesMenu(){
        System.out.print("\n");
        System.out.print(   "====================================================================\n"+
                            "                          Select Movie Type                         \n"+
                            "====================================================================\n");
        int backNo = 0;
        for (int i = 0; i < MovieEnums.MovieType.values().length; i++){
            System.out.println( "(" + (i+1) + ") " + MovieEnums.MovieType.values()[i] +
                                " (Current Charges: " +
                                String.format("%.2f", MovieEnums.MovieType.values()[i].getTicketPrice()) + ")");
            backNo++;
        }
        System.out.println("(" + (backNo+1) + ") " +
                            "Back\n" +
                            "====================================================================");
    }


    //Displays a menu for user to select which cinema type charges they want to edit and set
    public static void cinemaTypeChargesMenu(){
        System.out.print("\n");
        System.out.print(   "====================================================================\n"+
                            "                         Select Cinema Type                         \n"+
                            "====================================================================\n");
        int backNo = 0;
        for (int i = 0; i < CinemaType.values().length; i++){
            System.out.println( "(" + (i+1) + ") " + CinemaType.values()[i] +
                                " (Current Charges: " +
                                String.format("%.2f", CinemaType.values()[i].getTicketPrice()) + ")");
            backNo++;
        }
        System.out.println("(" + (backNo+1) + ") " +
                            "Back\n" +
                            "====================================================================");
    }


    //Display all the available public holidays settings in an interface
    public static void publicHolidayMenu(){
        System.out.print("\n");
        System.out.print(   "====================================================================\n"+
                            "                  Public Holiday/ Weekend Settings                  \n"+
                            "====================================================================\n"+
                            "(1) List Public Holidays\n" +
                            "(2) Add a Public Holiday\n" +
                            "(3) Remove a Public Holiday\n" +
                            "(4) Set Public Holiday Charges (Current Charges: SGD " +
                            String.format("%.2f", getPublicHolidayCharges()) + ")\n" +
                            "(5) Set Weekend Charges (Current Charges: SGD " +
                            String.format("%.2f", getWeekendCharges()) + ")\n" +
                            "(6) Back\n" +
                            "====================================================================\n");
    }

    public static void systemConfigurationMenu(){
        System.out.print("\n");
        System.out.print(   "====================================================================\n"+
                            "                      Configure System Setting                      \n"+
                            "====================================================================\n"+
                            "(1) Set Base Price (Current Base Price: " + String.format("%.2f", getBasePrice()) + ")\n" +
                            "(2) Movie Type Charges\n"+
                            "(3) Cinema Type Charges\n"+
                            "(4) Public Holiday/ Weekend Settings\n"+
                            "(5) Back\n" +
                            "====================================================================\n");
    }

    //Back option to allow user to go back to previous interface (Used in public holiday list interface)
    public static boolean backOption(){
        int opt;
        while (true) {
            Scanner in = new Scanner(System.in);
            try{
                System.out.print("Option: ");
                opt = in.nextInt();
                if (opt == 1) {   //Goes back to the previous interface
                    return true;
                }
                else{
                    System.out.println("[System: Invalid Input]");
                }
            } catch(Exception e){
                System.out.println("[System: Invalid Input]");
            }
        }
    }
}
