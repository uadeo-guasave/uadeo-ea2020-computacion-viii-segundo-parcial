package com.uadeo.computacion8.parcial2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    // Encapsulamiento
    private int id;
    private String name;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String remember_token;

    // Metodo para obtener todos los usuarios
    public static List<User> getAll() throws SQLException {
        String sql = "select id,name,email,firstname,lastname from users";
        try (Connection cnn = SqliteConnection.Connect();
             Statement stmt = cnn.createStatement();
             ResultSet rst = stmt.executeQuery(sql)) {
            List<User> users = new ArrayList<User>();
            while (rst.next()) {
                User u = new User();
                u.setId(rst.getInt("id"));
                u.setName(rst.getString("name"));
                u.setEmail(rst.getString("email"));
                u.setFirstname(rst.getString("firstname"));
                u.setLastname(rst.getString("lastname"));
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            throw e;
        }
    }

    // Método para validar el inicio de sesión
    public static User login(String _name, String _password) throws SQLException {
        String sql = "select id,name,email,firstname,lastname from users "
                   + "where name=? and password=?";
        try (Connection cnn = SqliteConnection.Connect();
             PreparedStatement stmt = cnn.prepareStatement(sql)) {
            stmt.setString(1, _name);
            stmt.setString(2, _password);
            ResultSet rst = stmt.executeQuery();
            if (rst.next()) {
                User user = new User();
                user.id = rst.getInt("id");
                user.name = rst.getString("name");
                user.email = rst.getString("email");
                user.firstname = rst.getString("firstname");
                user.lastname = rst.getString("lastname");
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    // Método para actualizar usuarios
    public void changePassword(String newPassword) throws SQLException {
        String sql = "update users set password=? where id=?";
        try (Connection cnn = SqliteConnection.Connect();
             PreparedStatement stmt = cnn.prepareStatement(sql);) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, this.id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    // TODO: getUserById, getUserByName, getUserByEmail, updateUser(first,last), deleteUser

    // Getters y Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }
}
