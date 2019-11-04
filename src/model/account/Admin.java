package model.account;

import model.Model;

public class Admin implements Model {

    private String username;

    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;

    }


}
