class Employee{

    int id;
    String name;
    String dept;
    int salary;

    Employee(int id,String name, String dept, int salary){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    
    Employee showDetails(){
        System.out.println("id = "+id);
        System.out.println("name = "+name);
        System.out.println("dept = "+dept);
        System.out.println("salary = "+salary);
        return this;
    }
}

class EmployeeDetails{
    public static void main(String[] args){
        Employee e1 = new Employee(1,"Sumit","IT",1000);
        Employee e2 = new Employee(2,"John","HR",2000);
        Employee e3 = new Employee(3,"Jane","IT",3000);

        Employee[] arr = {e1,e2,e3};

        for(Employee e : arr){
            e.showDetails();
        }
    }
}