package model.account;

import model.transaction.Booking;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private String email;
    private int mobileNumber;
    private ArrayList<Booking> bookingHistory = new ArrayList<Booking>();

    public Customer(String customerName, String email, int mobileNumber) {
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void addBookingHistory(Booking booking) {
        bookingHistory.add(booking);
    }
}
