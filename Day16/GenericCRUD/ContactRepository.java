import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactRepository implements Repository<Contact> {

    private Map<String, Contact> contacts = new HashMap<>();

    @Override
    public void add(Contact contact) {
        String id = contact.getPhoneNumber();

        if (contacts.containsKey(contact.getPhoneNumber())) {
            System.out.println("Contact already exists!");
            return;
        }

        contacts.put(id, contact);
        System.out.println("Contact added successfully!");
    }

    @Override
    public Contact findById(String id) {
        Contact c = contacts.get(id);

        if (c != null) {
            return c;
        } else {
            return null;
        }
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contacts.values());
    }
   
    @Override
    public boolean update(String id, Contact contact) {

        if (!contacts.containsKey(id)) {
            return false;
        }

        if (!id.equals(contact.getPhoneNumber())) {
            System.out.println("Phone number cannot be changed during update!");
            return false;
        }

        contacts.put(id, contact);
        return true;
    }

    @Override
    public boolean delete(String id) {

        if (contacts.containsKey(id)) {
            contacts.remove(id);
            return true;
        }

        return false;
    }
}
