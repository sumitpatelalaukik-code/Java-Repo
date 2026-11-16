package com.company.employee.service;

import java.util.List;
import java.util.ArrayList;
import com.company.employee.model.Employee;


public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        employees.add(employee);
        System.out.println("Employee Added");
    }

    public void displayAllEmployees(){
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }

    public Employee findEmployee(int id){
        for(Employee e : employees){
            if(e.getEmployeeId() == id)
                return e;
        }
        return null;
    }
}