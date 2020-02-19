import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {
    public static Connection Connect() throws SQLException {
        try {
            String url = "jdbc:sqlite:users.db";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw e;
        }
    }
}