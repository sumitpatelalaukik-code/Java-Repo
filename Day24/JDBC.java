import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            Statement st = con.createStatement();

            String query = "SELECT * FROM employee";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("empId") + " " +
                    rs.getString("empDepartment") + " " +
                    rs.getString("empRole")
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}