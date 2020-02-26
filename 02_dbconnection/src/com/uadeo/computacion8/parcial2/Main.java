package com.uadeo.computacion8.parcial2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hola IntelliJIDEA");
        String sql = "select id,name,email,firstname,lastname from users";
        try (Connection cnn = SqliteConnection.Connect();
             Statement stmt = cnn.createStatement();
             ResultSet rst = stmt.executeQuery(sql)) {
            while (rst.next()) {
                System.out.println(rst.getInt("id") + "\t" +
                                   rst.getString("name") + "\t" +
                                   rst.getString("email") + "\t" +
                                   rst.getString("firstname") + "\t" +
                                   rst.getString("lastname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
