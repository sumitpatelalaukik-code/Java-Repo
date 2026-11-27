package service;

import dao.EmployeeDAO;
import model.Employee;

import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public boolean addEmployee(Employee emp) {
        if (emp.getName() == null || emp.getName().isBlank()
                || emp.getEmail() == null || emp.getEmail().isBlank()
                || emp.getDepartment() == null
                || emp.getDepartment().isBlank()
                || emp.getSalary() <= 0) {

            System.out.println("Invalid employee details!");
            return false;
        }

        return employeeDAO.addEmployee(emp);
    }


    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }


    public boolean updateEmployee(Employee emp) {
        if (emp.getId() <= 0 || emp.getName() == null
                || emp.getName().isBlank()
                || emp.getEmail() == null
                || emp.getEmail().isBlank()
                || emp.getDepartment() == null
                || emp.getDepartment().isBlank()
                || emp.getSalary() <= 0) {

            System.out.println("Invalid employee details!");
            return false;
        }

        return employeeDAO.updateEmployee(emp);
    }


    public boolean deleteEmployee(int id) {
        if (id <= 0) {
            System.out.println("Invalid employee ID!");
            return false;
        }
        return employeeDAO.deleteEmployee(id);
    }

   
    public Employee searchEmployee(int id) {
        if (id <= 0) {
            System.out.println("Invalid employee ID!");
            return null;
        }
        return employeeDAO.getEmployeeById(id);
    }
}
