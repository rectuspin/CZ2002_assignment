package test;

import controller.DBController;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static view.TicketPriceView.ticketPriceView;

public class DatabaseTest {
        public static void main(String[] args) throws ParseException, IOException {
            //Uncomment the statements to test
            DBController DBService = new DBController();
            //DBService.readDB("testDB");
            List list = new ArrayList<>();
            //DBService.updateDB(list, "testDB");
        }
    }
