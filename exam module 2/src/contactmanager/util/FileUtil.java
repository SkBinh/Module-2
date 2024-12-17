package contactmanager.util;

import contactmanager.model.Contact;

import java.io.*;
import java.util.List;

public class FileUtil {

    public static boolean readFromFile(String fileName, List<Contact> contacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String name = data[0].trim();
                    String phone = data[1].trim();
                    String group = data[2].trim();
                    String gender = data[3].trim();
                    String address = data[4].trim();
                    String birthDate = data[5].trim();
                    String email = data[6].trim();

                    Contact contact = new Contact(name, phone, group, gender, address, birthDate, email);
                    contacts.add(contact);
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ file: " + e.getMessage());
            return false;
        }
    }

    public static boolean writeToFile(String fileName, List<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                String line = contact.getName() + "," +
                        contact.getPhone() + "," +
                        contact.getGroup() + "," +
                        contact.getGender() + "," +
                        contact.getAddress() + "," +
                        contact.getBirthDate() + "," +
                        contact.getEmail();
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
            return false;
        }
    }
}
