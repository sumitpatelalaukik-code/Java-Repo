package com.company.employee.util;

public class EmployeeUtil {
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }
}