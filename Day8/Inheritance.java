class Employee{
    private int empId;
    private String name;
    
    public Employee(int empId, String name){
        this.empId = empId;
        this.name = name;
    }
    
    public void display(){
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
    }
}

class Developer extends Employee{
    private String domain;

    public Developer(int empId, String name, String domain){
        super(empId, name);
        this.domain = domain;
    }

    public void display(){
        super.display();
        System.out.println("Domain: " + domain);
    }
}

class SeniorDeveloper extends Developer{
    private int noOfProjects;

    public SeniorDeveloper(int empId, String name, String domain, int noOfProjects){
        super(empId, name, domain);
        this.noOfProjects = noOfProjects;
    }

    public void display(){
        super.display();
        System.out.println("Number of Projects: " + noOfProjects);
    }
    
}

class Main{
    public static void main(String[] args){
        SeniorDeveloper s1 = new SeniorDeveloper(1, "John", "Java", 10);
        s1.display();
    }
}