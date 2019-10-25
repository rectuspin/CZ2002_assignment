package model.account;

import model.cinema.Cineplex;

import java.util.HashMap;

public class Admin {

    private static HashMap<String, Cineplex> cineplexes = new HashMap<>();

    private String username;

    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static HashMap<String, Cineplex> getCineplexes() {
        return cineplexes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
