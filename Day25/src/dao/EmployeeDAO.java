
package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO employees " +
                     "(name, email, department, salary) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding employee: "
                               + e.getMessage());
            return false;
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Employee emp = new Employee();

                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));

                employees.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employees: "
                               + e.getMessage());
        }
        return employees;
    }

    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET " +
                     "name = ?, email = ?, department = ?, " +
                     "salary = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating employee: "
                               + e.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting employee: "
                               + e.getMessage());
            return false;
        }
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Employee emp = new Employee();

                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setDepartment(rs.getString("department"));
                    emp.setSalary(rs.getDouble("salary"));

                    return emp;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching employee: "
                               + e.getMessage());
        }

        return null;
    }
}