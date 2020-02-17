import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String rememberToken;
    private Connection cnn;

    // CRUD - Create Read Update Delete
    public static void main(String[] args) {
        User u = new User();
        u.Connect();
    }

    public void Connect() {
        try {
            String url = "jdbc:sqlite:users.db";
            this.cnn = DriverManager.getConnection(url);
            System.out.println("Conexión a sqlite establecida correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (this.cnn != null) {
                    this.cnn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void All() {}
    public void Add() {}
    public void FindById(int id) {}
    public void SaveChanges() {}
    public void Delete(int id) {}
}