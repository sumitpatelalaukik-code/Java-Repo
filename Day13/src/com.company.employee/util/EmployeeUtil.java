package com.company.employee.util;

public class EmployeeUtil {

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static String formatName(String name) {
        return name.trim().toUpperCase();
    }
}