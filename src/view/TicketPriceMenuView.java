package view;

import model.AgeGroup;
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

        System.out.print(   "==================================================\n"+
                            "|              Public Holiday Dates              |\n"+
                            "==================================================\n");
        if (getPublicHolidayDates().size()== 0){
            System.out.print("| There is no public holidays currently...       |\n");
        }else {
            for (LocalDate d : getPublicHolidayDates()) {
                System.out.format("| " + d.format(dateFormat) + "%28s\n", "|");
            }
        }
        System.out.println( "==================================================");
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
        System.out.print(   "===========================================================\n"+
                            "|                    Movie Type Charge                    |\n"+
                            "===========================================================\n");
        int backNo = 0;
        for (int i = 0; i < MovieEnums.MovieType.values().length; i++){
            System.out.format( "| %-54s  |\n", "(" + (i+1) + ") " + MovieEnums.MovieType.values()[i] +
                                " (Current Charges: " +
                                String.format("%.2f", MovieEnums.MovieType.values()[i].getTicketPrice()) + ")");
            backNo++;
        }
        System.out.format("| %-54s  |\n", "(" + (backNo+1) + ") " +
                            "Back");
        System.out.print("===========================================================\n");
    }


    //Displays a menu for user to select which cinema type charges they want to edit and set
    public static void cinemaTypeChargesMenu(){
        System.out.print("\n");
        System.out.print(   "============================================================\n"+
                            "|                    Cinema Type Charge                    |\n"+
                            "============================================================\n");
        int backNo = 0;
        for (int i = 0; i < CinemaType.values().length; i++){
            System.out.format( "| %-55s  |\n","(" + (i+1) + ") " + CinemaType.values()[i] +
                                " (Current Charges: " +
                                String.format("%.2f", CinemaType.values()[i].getTicketPrice()) + ")");
            backNo++;
        }
        System.out.format("| %-55s  |\n", "(" + (backNo+1) + ") " +
                "Back");
        System.out.print("============================================================\n");
    }

    //Displays a menu for user to select which age group discount they want to edit and set
    public static void citizenCategoryMenu(){
        System.out.print("\n");
        System.out.print(   "============================================================\n"+
                            "|                     Citizen Discount                     |\n"+
                            "============================================================\n");
        int backNo = 0;
        for (int i = 1; i < AgeGroup.values().length; i++){
            System.out.format( "| %-55s  |\n","(" + i + ") " + AgeGroup.values()[i] +
                    " (Current Discount: " +
                    String.format("%.2f", AgeGroup.values()[i].getTicketPrice()) + ")");
            backNo++;
        }
        System.out.format("| %-55s  |\n", "(" + (backNo+1) + ") " +
                "Back");
        System.out.print("============================================================\n");
    }


    //Display all the available public holidays settings in an interface
    public static void publicHolidayMenu(){
        System.out.print("\n");
        System.out.format(  "=================================================================\n"+
                            "|               Public Holiday / Weekend Settings               |\n"+
                            "=================================================================\n"+
                            "| %-61s |\n" +
                            "| %-61s |\n" +
                            "| %-61s |\n" +
                            "| %-61s |\n" +
                            "| %-61s |\n" +
                            "| %-61s |\n" +
                            "=================================================================\n",
                            "(1) List Public Holidays" ,
                            "(2) Add a Public Holiday" ,
                            "(3) Remove a Public Holiday" ,
                            "(4) Set Public Holiday Charges (Current Charges: SGD " +
                            String.format("%.2f", getPublicHolidayCharges()) + ")" ,
                            "(5) Set Weekend Charges (Current Charges: SGD " +
                            String.format("%.2f", getWeekendCharges()) + ")" ,
                            "(6) Back");
    }

    public static void systemConfigurationMenu(){
        System.out.print("\n");
        System.out.format(  "===========================================================\n"+
                            "|                Configure System Settings                |\n"+
                            "===========================================================\n"+
                            "| %-55s |\n" +
                            "| %-55s |\n" +
                            "| %-55s |\n" +
                            "| %-55s |\n" +
                            "| %-55s |\n" +
                            "| %-55s |\n" +
                            "===========================================================\n",
                            "(1) Set Base Price (Current Price: " + String.format("%.2f", getBasePrice()) + ")",
                            "(2) Movie Type Charges",
                            "(3) Cinema Type Charges",
                            "(4) Special Citizen Discount" ,
                            "(5) Public Holiday/ Weekend Settings",
                            "(6) Back"
                            );
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
