package com.company.employee;

import java.util.Scanner;
import com.company.employee.model.Employee;
import com.company.employee.service.EmployeeService;
import com.company.employee.util.EmployeeUtil;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EmployeeService service = new EmployeeService();

        int choice;

        do{
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println(" 1: Add Employee ");
            System.out.println(" 2: Update Employee ");
            System.out.println(" 3: Remove Employee ");
            System.out.println(" 4: Search Employee ");
            System.out.println(" 5: Display All Employee ");
            System.out.println(" 6: Exit ");

            System.out.print("\nEnter Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: 
                    System.out.println("Enter ID : ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name : ");
                    String empName = sc.nextLine();

                    System.out.println("Enter Salary : ");
                    int empSalary = sc.nextInt();
                    sc.nextLine();

                    if (!EmployeeUtil.isValidName(empName) ||
                        !EmployeeUtil.isValidSalary(empSalary)) {

                        System.out.println("Invalid employee details!");
                        break;
                    }

                    Employee employee = new Employee(empId, empName, empSalary);
                    service.addEmployee(employee);
                    break;
                
                case 2: 
                    System.out.println("Enter EmployeeID that you want to update :");
                    int newEmpId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter updated Name : ");
                    String newEmpName = sc.nextLine();

                    System.out.println("Enter updated Salary : ");
                    int newEmpSalary = sc.nextInt();
                    sc.nextLine();

                    if (!EmployeeUtil.isValidName(newEmpName) ||
                        !EmployeeUtil.isValidSalary(newEmpSalary)) {

                        System.out.println("Invalid employee details!");
                        break;
                    }
                    service.updateEmployee(newEmpId, newEmpName, newEmpSalary);
                    break;

                case 3:
                    System.out.println("Enter EmployeeID that you want to remove :");
                    int empId1 = sc.nextInt();
                    sc.nextLine();

                    service.removeEmployee(empId1);
                    break;

                case 4:
                    System.out.println("Enter EmployeeID that you want to search :");
                    int empId2 = sc.nextInt();
                    sc.nextLine();

                    Employee emp = service.getEmployee(empId2);
                    System.out.println(emp);
                    break;
                    
                case 5:
                    service.getAllEmployees();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }while (choice != 6);

        sc.close();
    }
}