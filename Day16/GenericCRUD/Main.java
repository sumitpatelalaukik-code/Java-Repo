
public class Main {

    public static void main(String[] args) {

        Repository<Contact> repository = new ContactRepository();

        repository.add(
            new Contact("Sumit", "9876543210", "sumit@gmail.com")
        );

        repository.add(
            new Contact("Sufiyan", "9876543211", "sufiyan@gmail.com")
        );

        repository.add(
            new Contact("Rahul", "9876543210", "rahul@gmail.com")
        );

        System.out.println("\n----- Search Contact -----");

        Contact contact = repository.findById("9876543210");

        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact not found!");
        }

        System.out.println("\n----- All Contacts -----");

        for (Contact c : repository.findAll()) {
            System.out.println(c);
        }

        System.out.println("\n----- Update Contact -----");

        Contact updatedContact = new Contact(
            "Sumit Patel",
            "9876543210",
            "sumitpatel@gmail.com"
        );

        boolean updated = repository.update(
            "9876543210", updatedContact
        );

        System.out.println(
            updated ? "Updated successfully!" : "Contact not found!"
        );

        System.out.println("\n----- Delete Contact -----");

        boolean deleted = repository.delete("9876543211");

        System.out.println(
            deleted ? "Deleted successfully!" : "Contact not found!"
        );

        System.out.println("\n----- Final Contact List -----");

        for (Contact c : repository.findAll()) {
            System.out.println(c);
        }
    }
}
