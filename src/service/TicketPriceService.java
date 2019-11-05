package service;

import model.cinema.CinemaType;
import model.movie.MovieEnums;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TicketPriceService {

    private static ArrayList<LocalDate> publicHolidayDates = new ArrayList<LocalDate>();
    private static double publicHolidayCharges;
    private static double weekendCharges;
    private static double basePrice; //Universal Base Price

    public static void setMovieTypeCharges(int opt, double prices){ MovieEnums.MovieType.values()[opt-1].setTicketPrice(prices); }

    public static void setCinemaTypeCharges(int opt, double prices){ CinemaType.values()[opt-1].setTicketPrice(prices); }

    public static void setPublicHolidayCharges(double charges){ publicHolidayCharges = charges; }

    public static double getPublicHolidayCharges(){ return publicHolidayCharges; }

    public static void setPublicHolidayDates(ArrayList<LocalDate> publicHolidays){ publicHolidayDates = publicHolidays; }

    public static ArrayList<LocalDate> getPublicHolidayDates(){ return publicHolidayDates; }

    public static void setWeekendCharges(double charges){ weekendCharges = charges; }

    public static double getWeekendCharges(){ return weekendCharges;}

    public static void setBasePrice(double price){ basePrice = price; }

    public static double getBasePrice(){ return basePrice; }

    //Checks if the selected day matches with given date
    public static boolean isWeekend(LocalDate date){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E");
        if (date.format(dateFormat).equals("Sun") || date.format(dateFormat).equals("Sat")){
            return true;
        }
        return false;
    }

    public static boolean addPublicHolidayDates(LocalDate date){
        for (LocalDate d : publicHolidayDates){
            if (d.equals(date)){
                return false;
            }
        }
        publicHolidayDates.add(date);
        return true;
    }

    public static boolean removePublicHolidayDates(LocalDate date){
        for (LocalDate d : publicHolidayDates){
            if (d.equals(date)){
                publicHolidayDates.remove(date);
                return true;
            }
        }
        return false;
    }

    //Checks if the selected date matches with dates in publicHolidayDates array
    public static boolean isHoliday(LocalDate date){
        for (LocalDate d : publicHolidayDates){
            if (date.equals(d)){
                return true;
            }
        }
        return false;
    }
}
