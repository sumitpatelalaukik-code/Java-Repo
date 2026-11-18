import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class ContactService {

    private Set<Contact> contacts = new HashSet<>();

    private Map<String, Contact> contactMap = new HashMap<>();

    public void addContact(Contact contact) {

        if (contactMap.containsKey(contact.getPhoneNumber())) {
            System.out.println("Contact already exists!");
            return;
        }

        contacts.add(contact);
        contactMap.put(contact.getPhoneNumber(), contact);

        System.out.println("Contact added successfully!");
    }

    public void searchContact(String phoneNumber) {

        Contact contact = contactMap.get(phoneNumber);

        if (contact != null) {
            System.out.println("Contact found:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found!");
        }
    }

    public void deleteContact(String phoneNumber) {

        Contact contact = contactMap.remove(phoneNumber);

        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    public void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available!");
            return;
        }

        System.out.println("\n----- Contact List -----");

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
