package com.company.employee;

import com.company.employee.model.Employee;
import com.company.employee.service.EmployeeService;
import com.company.employee.util.EmployeeUtil;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        String name1 = EmployeeUtil.formatName("Rahul");

        if (EmployeeUtil.isValidSalary(50000)) {
            Employee emp1 = new Employee(101, name1, 50000);
            service.addEmployee(emp1);
        }

        String name2 = EmployeeUtil.formatName("Amit");

        if (EmployeeUtil.isValidSalary(60000)) {
            Employee emp2 = new Employee(102, name2, 60000);
            service.addEmployee(emp2);
        }

        String name3 = EmployeeUtil.formatName("Sumit");

        if (EmployeeUtil.isValidSalary(70000)) {
            Employee emp3 = new Employee(103, name3, 70000);
            service.addEmployee(emp3);
        }

        System.out.println("\nDisplaying All Employees: ");
        service.displayAllEmployees();

        System.out.println("\nSearching Employee : ");
        Employee found = service.findEmployee(101);

        if (found != null) {
            System.out.println("Employee Found: " + found);
        } else {
            System.out.println("Employee Not Found!");
        }
    }
}