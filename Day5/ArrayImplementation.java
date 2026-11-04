import java.util.Scanner;
class ArrayImplementation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int size = sc.nextInt();
        sc.nextLine();

        String[] name = new String[size];
        int[] marks = new int[size];
        char[] grade = new char[size];
        
        for(int i=0; i<size; i++){
            System.out.print("Enter Name of Student " + (i+1) + ": ");
            name[i] = sc.nextLine();

            System.out.print("Enter Marks of Student " + (i+1) + ": ");
            marks[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Grade of Student " + (i+1) + ": ");
            grade[i] = sc.nextLine().charAt(0);

            System.out.println();
        }

        System.out.println("Details of Students are....");
        for(int i=0; i<size; i++){
            System.out.print(name[i] + " ");
            System.out.print(marks[i] + " ");
            System.out.println(grade[i]);
        }
    }
}