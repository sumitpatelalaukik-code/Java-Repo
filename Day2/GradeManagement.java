import java.util.Scanner;
class GradeManagement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of Student: ");
        String name = sc.nextLine();
        System.out.println("Marks of 5 Subjects: ");

        System.out.println("Marks in Hindi: ");
        int marks1 = sc.nextInt();
        System.out.println("Marks in English: ");
        int marks2 = sc.nextInt();
        System.out.println("Marks in Mathematics: ");
        int marks3 = sc.nextInt(); 
        System.out.println("Marks in Science: ");
        int marks4 = sc.nextInt();
        System.out.println("Marks in Social Studies: ");
        int marks5 = sc.nextInt();

        int totalMarks = marks1 + marks2 + marks3 + marks4 + marks5;
        double percentage = (totalMarks / 500.0) * 100;

        System.out.println("Total Marks: " + totalMarks + "/500");
        System.out.println("Percentage: " + percentage + "%");

        if(percentage >= 90){
            System.out.println("Grade: A");
            System.out.println("Passed..");
        } else if(percentage >= 80){
            System.out.println("Grade: B");
            System.out.println("Passed..");
        } else if(percentage >= 70){
            System.out.println("Grade: C");
            System.out.println("Passed..");
        } else if(percentage >= 60){
            System.out.println("Grade: D");
            System.out.println("Pass with Grace..!");
        } else {
            System.out.println("Grade: F");
            System.out.println("Failed..!!");
        }
    }
}