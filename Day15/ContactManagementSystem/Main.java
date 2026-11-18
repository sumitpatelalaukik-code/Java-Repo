import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactService service = new ContactService();

        int choice;

        do {
            System.out.println("\n===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Contact contact = new Contact(name, phone, email);

                    service.addContact(contact);
                    break;

                case 2:
                    System.out.print("Enter Phone Number to Search: ");
                    String searchPhone = sc.nextLine();

                    service.searchContact(searchPhone);
                    break;

                case 3:
                    System.out.print("Enter Phone Number to Delete: ");
                    String deletePhone = sc.nextLine();

                    service.deleteContact(deletePhone);
                    break;

                case 4:
                    service.displayContacts();
                    break;

                case 5:
                    System.out.println("Thank you for using Contact Management System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
