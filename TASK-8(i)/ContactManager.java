import java.util.HashMap;
import java.util.Map;

class ContactManager {
    private Map<String, String> contacts;

    public ContactManager() {
        this.contacts = new HashMap<>();
    }

    // Method to add a contact
    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Contact added: " + name);
    }

    // Method to remove a contact
    public void removeContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact removed: " + name);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Method to retrieve a contact's phone number
    public String getPhoneNumber(String name) {
        return contacts.getOrDefault(name, "Contact not found.");
    }

    // Method to list all contacts
    public void listAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contact List:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        // Adding contacts
        contactManager.addContact("Alice", "123-456-7890");
        contactManager.addContact("Bob", "987-654-3210");
        contactManager.addContact("Charlie", "555-666-7777");

        // Retrieving a contact
        System.out.println("Bob's Phone Number: " + contactManager.getPhoneNumber("Bob"));

        // Removing a contact
        contactManager.removeContact("Alice");

        // Listing all contacts
        contactManager.listAllContacts();
    }
}
