import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Sumit", "IT", 50000));
        employees.add(new Employee(102, "Rahul", "HR", 30000));
        employees.add(new Employee(103, "Amit", "IT", 60000));
        employees.add(new Employee(104, "Sufiyan", "Finance", 40000));
        employees.add(new Employee(105, "Priya", "HR", 70000));

        System.out.println("\n----- Employees with salary > 40000 -----");
        employees.stream()
                .filter(e -> e.getSalary() > 40000)
                .forEach(e -> System.out.println(e));

        System.out.println("\n----- Employees sorted by salary -----");
        employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary()))
                .forEach(e -> System.out.println(e));

        System.out.println("\n----- Total Salary -----");
        double totalSalary = employees.stream()
                .mapToDouble(e -> e.getSalary())
                .sum();

        System.out.println("Total Salary: " + totalSalary);

        System.out.println("\n----- Search Employee -----");
        String searchName = "Sumit";
        employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(searchName))
                .forEach(e -> System.out.println(e));

    }
}
