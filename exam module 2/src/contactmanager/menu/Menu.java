package contactmanager.menu;

import contactmanager.model.Contact;
import contactmanager.service.ContactService;
import contactmanager.util.FileUtil;
import contactmanager.util.Validator;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactService contactService = new ContactService();
    private static final Validator validate = new Validator();

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n----- Quản lý danh bạ -----");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới người liên lạc");
            System.out.println("3. Cập nhật người liên lạc");
            System.out.println("4. Xóa người liên lạc");
            System.out.println("5. Tìm kiếm người liên lạc");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    contactService.viewAllContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    readFromFile();
                    break;
                case 7:
                    writeToFile();
                    break;
                case 8:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void addContact() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        if (!validate.isValidName(name)) {
            System.out.println("Tên không hợp lệ.");
            return;
        }

        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        if (!validate.isValidPhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ.");
            return;
        }

        System.out.print("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập ngày sinh (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        if (!validate.isValidDate(birthDate)) {
            System.out.println("Ngày sinh không hợp lệ.");
            return;
        }

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        if (!validate.isValidEmail(email)) {
            System.out.println("Email không hợp lệ.");
            return;
        }

        contactService.addContact(name, phone, group, gender, address, birthDate, email);
        System.out.println("Thêm mới người liên lạc thành công.");
    }

    private void updateContact() {
        System.out.print("Nhập tên người liên lạc muốn cập nhật: ");
        String oldName = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contactService.getContacts()) {
            if (contact.getName().equalsIgnoreCase(oldName)) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy người liên lạc với tên: " + oldName);
            return;
        }

        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập số điện thoại mới: ");
        String newPhone = scanner.nextLine();
        System.out.print("Nhập nhóm mới: ");
        String newGroup = scanner.nextLine();
        System.out.print("Nhập giới tính mới: ");
        String newGender = scanner.nextLine();
        System.out.print("Nhập địa chỉ mới: ");
        String newAddress = scanner.nextLine();
        System.out.print("Nhập ngày sinh mới (YYYY-MM-DD): ");
        String newBirthDate = scanner.nextLine();
        System.out.print("Nhập email mới: ");
        String newEmail = scanner.nextLine();

        contactService.updateContact(oldName, newName, newPhone, newGroup, newGender, newAddress, newBirthDate, newEmail);
        System.out.println("Cập nhật thông tin người liên lạc thành công.");
    }

    private void deleteContact() {
        System.out.print("Nhập tên người liên lạc cần xóa: ");
        String name = scanner.nextLine();
        if (contactService.deleteContact(name)) {
            System.out.println("Xóa người liên lạc thành công.");
        } else {
            System.out.println("Không tìm thấy người liên lạc với tên: " + name);
        }
    }

    private void searchContact() {
        System.out.print("Nhập tên người liên lạc cần tìm: ");
        String name = scanner.nextLine();
        Contact contact = contactService.searchContact(name);

        if (contact != null) {
            System.out.println("Thông tin người liên lạc tìm thấy:");
            System.out.println(contact);
        } else {
            System.out.println("Không tìm thấy người liên lạc với tên: " + name);
        }
    }

    private void readFromFile() {
        String fileName = "C:\\Users\\SkBinh\\Codegym\\module 2\\exam module 2\\src\\contacts.cvs";
        if (FileUtil.readFromFile(fileName, contactService.getContacts())) {
            System.out.println("Đọc dữ liệu từ file thành công.");
        } else {
            System.out.println("Lỗi khi đọc dữ liệu từ file.");
        }
    }

    private void writeToFile() {
        String fileName = "C:\\Users\\SkBinh\\Codegym\\module 2\\exam module 2\\src\\contacts.cvs";
        if (FileUtil.writeToFile(fileName, contactService.getContacts())) {
            System.out.println("Ghi dữ liệu vào file thành công.");
        } else {
            System.out.println("Lỗi khi ghi dữ liệu vào file.");
        }
    }
}
