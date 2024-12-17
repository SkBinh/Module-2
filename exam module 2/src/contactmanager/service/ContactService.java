package contactmanager.service;

import contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(String name, String phone, String group, String gender, String address, String birthDate, String email) {
        Contact contact = new Contact(name, phone, group, gender, address, birthDate, email);
        contacts.add(contact);
        System.out.println("Đã thêm mới người liên lạc.");
    }

    public void updateContact(String oldName, String newName, String newPhone, String newGroup, String newGender, String newAddress, String newBirthDate, String newEmail) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(oldName)) {
                contact.setName(newName);
                contact.setPhone(newPhone);
                contact.setGroup(newGroup);
                contact.setGender(newGender);
                contact.setAddress(newAddress);
                contact.setBirthDate(newBirthDate);
                contact.setEmail(newEmail);
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy người liên lạc với tên: " + oldName);
    }

    public boolean deleteContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Đã xóa người liên lạc.");
                return true;
            }
        }
        System.out.println("Không tìm thấy người liên lạc với tên: " + name);
        return false;
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        System.out.println("Không tìm thấy người liên lạc với tên: " + name);
        return null;
    }

    public void viewAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
        } else {
            System.out.println("Danh sách các người liên lạc:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}
