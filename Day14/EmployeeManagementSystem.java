import java.util.List;
import java.util.ArrayList;

class Employee {
    private int empId;
    private String name;
    private String department;
    private double salary;

}

class EmpolyeeManagementSystem {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee Added");
    }

    public void updateEmployee(int empId) {
        Employee emp = employees.get(empId);
    }

    public void removeEmployee(int empId) {
        
    }

    public Employee searchEmployee(int empId) {
        
    }

    public void displayAllEmployee() {
        
    }
}