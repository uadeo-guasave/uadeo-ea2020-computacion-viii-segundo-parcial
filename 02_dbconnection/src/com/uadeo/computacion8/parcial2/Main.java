package com.uadeo.computacion8.parcial2;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<User> users = User.getAll();
            System.out.println(users.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = User.login("bidkar", "123");
            System.out.println("Hola " + user.getFirstname() + " " + user.getLastname());
            user.changePassword("321");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
