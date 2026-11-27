import model.Employee;
import service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeService service = new EmployeeService();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n================================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    updateEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    searchEmployee();
                    break;

                case 6:
                    System.out.println("Thank you for using EMS!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    
    private static void addEmployee() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = readDouble();

        Employee emp = new Employee(name, email, department, salary);

        if (service.addEmployee(emp)) {
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Employee could not be added.");
        }
    }


    private static void viewEmployees() {
        List<Employee> employees = service.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }
        System.out.println("\n---------- EMPLOYEE LIST ----------");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }


    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = readInt();

        Employee existing = service.searchEmployee(id);

        if (existing == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        System.out.print("Enter New Department: ");
        String department = sc.nextLine();

        System.out.print("Enter New Salary: ");
        double salary = readDouble();

        Employee emp = new Employee(
                name, email, department, salary
        );

        emp.setId(id);

        if (service.updateEmployee(emp)) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee update failed!");
        }
    }

   
    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = readInt();

        if (service.deleteEmployee(id)) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found or delete failed!");
        }
    }


    private static void searchEmployee() {
            System.out.print("Enter Employee ID: ");
            int id = readInt();

            Employee emp = service.searchEmployee(id);
            if (emp != null) {
                System.out.println(emp);
            } else {
                System.out.println("Employee not found!");
            }
    }

    private static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine());

                if (Double.isFinite(value)) {
                    return value;
                }

                System.out.print("Enter a finite number: ");

            } catch (NumberFormatException e) {
                System.out.print("Enter a valid salary: ");
            }
        }
    }
}
