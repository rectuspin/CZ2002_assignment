package test;

import controller.DBController;
import model.account.Admin;
import model.cinema.Cinema;
import model.cinema.Cineplex;
import service.AdminCineplexService;

import java.util.ArrayList;
import java.util.Scanner;

public class adminSettingsTest {
    public static void main(String[] args) {
        Admin admin = new Admin("KS", "123456");
        AdminCineplexService adminService = new AdminCineplexService(admin);

        //Creating cineplexes
        Cineplex cineplex;
        cineplex = new Cineplex("CINEPLEX1");
        adminService.addCineplex(cineplex);
        cineplex = new Cineplex("CINEPLEX2");
        adminService.addCineplex(cineplex);
        cineplex = new Cineplex("CINEPLEX3");
        adminService.addCineplex(cineplex);

        //Creating a cinema and storing it to a cineplex
        Cinema cinema = new Cinema("CINEMA1");
        adminService.addCinema(cineplex, cinema);
        Cineplex cineplex1 = (Cineplex)adminService.getCineplexes().get("CINEPLEX3");
        System.out.println(cineplex1.getName());

        //Show output
        Cineplex cineplex2 = (Cineplex) adminService.getCineplexes().get("CINEPLEX3");
        System.out.println(cineplex2.getCinemas().get(0).getName());
        creatingCineplexSettings(admin);
    }

    public static void creatingCineplexSettings(Admin admin){

        AdminCineplexService adminService = new AdminCineplexService(admin);
        System.out.println( "====================================================================\n"+
                            "                     Cineplex / Cinema Settings                     \n"+
                            "====================================================================\n" +
                            "(1) Add Cineplex\n" +
                            "(2) Add Cinema\n" +
                            "====================================================================\n");
        Scanner in = new Scanner(System.in);
        int opt ;
        String cineplexName, cinemaName;
        int cineplexOpt;
        while(true){
            System.out.print("\nSelect an option: ");
            opt = in.nextInt();
            if (opt == 1){
                System.out.print("Please input a cineplex name: ");
                cineplexName = in.next();
                Cineplex cineplex = new Cineplex(cineplexName);
                adminService.addCineplex(cineplex);
            }
            else if (opt == 2){
                ArrayList<String> cineplex = new ArrayList<>();
                for (Object c : adminService.getCineplexes().values()){
                    Cineplex cineplex_obj = (Cineplex) c;
                    String cineplex_name = cineplex_obj.getName();
                    cineplex.add(cineplex_name);
                }
                System.out.println( "====================================================================\n"+
                                    "                          All Cineplex List                         \n"+
                                    "====================================================================");
                int i = 1;
                for ( String c : cineplex){
                    System.out.println("("+ i + ") " + c );
                    i++;
                }
                System.out.println( "====================================================================\n");
                System.out.print( "Please Select a Cineplex: ");
                cineplexOpt = in.nextInt();
                System.out.print("Please enter a cinema name: ");
                cinemaName = in.next();
                Cinema cinema = new Cinema(cinemaName);
                adminService.addCinema((Cineplex) adminService.getCineplexes().get(cineplex.get(cineplexOpt-1)), cinema);
                Cinema cinema1 = ((Cineplex) adminService.getCineplexes().get(cineplex.get(cineplexOpt-1))).getCinemas().get(0);
                System.out.print(cinema1.getName());
            }
        }
    }
}
