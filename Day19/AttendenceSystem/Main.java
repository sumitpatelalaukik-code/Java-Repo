import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceService service = new AttendanceService();
        int choice;
        do {
            System.out.println("\n===== Employee Attendance System =====");
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3. Attendance Report");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int checkInId = sc.nextInt();
                    service.checkIn(checkInId);
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int checkOutId = sc.nextInt();
                    service.checkOut(checkOutId);
                    break;

                case 3:
                    service.attendanceReport();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
        sc.close();
    }
}
