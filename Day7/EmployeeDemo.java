import java.util.Scanner;

class Employee{
    private int id;
    private String name;
    private String dept;
    private int salary;

    protected Employee(int id,String name, String dept, int salary){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    
    protected void showDetails(){
        System.out.println("id = "+id);
        System.out.println("name = "+name);
        System.out.println("dept = "+dept);
        System.out.println("salary = "+salary);  
    }
}

class EmployeeDemo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of employees: ");
        int n = sc.nextInt();
        Employee[] arr = new Employee[n];

        for(int i = 0;i<n;i++){
            System.out.print("Enter the id of employee "+ (i+1) +": ");
            int id = sc.nextInt();
            System.out.print("Enter the name of employee "+ (i+1) +": ");
            String name = sc.next();
            System.out.print("Enter the dept of employee "+ (i+1) +": ");
            String dept = sc.next();
            System.out.print("Enter the salary of employee "+ (i+1) +": ");
            int salary = sc.nextInt();
            System.out.println("--------------------------------------");
            arr[i] = new Employee(id,name,dept,salary);
        }
        sc.close();
        System.out.println("\nEmployee Details");
        for(Employee e : arr){
            e.showDetails();
            System.out.println();
        }
    }
}
