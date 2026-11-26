import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}