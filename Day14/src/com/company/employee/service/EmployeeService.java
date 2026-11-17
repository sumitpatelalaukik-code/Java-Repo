package com.company.employee.service;

import java.util.List;
import java.util.ArrayList;
import com.company.employee.model.Employee;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee added successfully");
    }

    public void removeEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
        System.out.println("Employee removed successfully");
    }

    public Employee getEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

   public void updateEmployee(int id, String name, double salary) {
    Employee employee = getEmployee(id);
    if (employee != null) {
        employee.setName(name);
        employee.setSalary(salary);

        System.out.println("Employee updated successfully!");
    } else {
        System.out.println("Employee not found!");
    }
}

    public void getAllEmployees() {
        for(Employee e : employees){
            System.out.println("\n" + e);
        }
    }
}