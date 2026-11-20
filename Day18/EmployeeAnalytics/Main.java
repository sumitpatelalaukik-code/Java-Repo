import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1,"John","IT",100000));
        employees.add(new Employee(2,"Alice","HR",120000));
        employees.add(new Employee(3,"Bob","IT",40000));
        employees.add(new Employee(4,"Charlie","Finance",40000));
        employees.add(new Employee(5,"David","Sales",50000));
        employees.add(new Employee(6,"Eve","HR",60000));
        employees.add(new Employee(7,"Frank","Sales",30000));
     
        System.out.println("\n--- Employees with Salary > 50000 ---");
        employees.stream()
        .filter(emp->emp.getSalary() > 50000)
        .forEach(e -> System.out.println(e));
            
       System.out.println("\n--- Employees by Department ---");
        Map<String, List<Employee>> departmentEmployees =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getDepartment()
                        ));

        departmentEmployees.forEach((department, empList) -> {
            System.out.println("\nDepartment: " + department);
            empList.forEach(e -> System.out.println(e));
        });

        System.out.println("\n--- Highest Salary Employee ---");
        Employee highestSalary = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

        System.out.println(highestSalary);

        System.out.println("\n--- Average Salary ---");
        double averageSalary = employees.stream()
                .mapToDouble(e -> e.getSalary())
                .average()
                .orElse(0.0);

        System.out.println("Average Salary: " + averageSalary);
    }
}
    