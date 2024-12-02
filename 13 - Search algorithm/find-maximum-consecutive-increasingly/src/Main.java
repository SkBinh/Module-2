import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> current = new LinkedList<>(); // Đổi tên cho dễ hiểu

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();

        // Tìm chuỗi liên tiếp có độ dài lớn nhất
        for (int i = 0; i < string.length(); i++) {
            // Nếu ký tự hiện tại khác ký tự trước đó,
            // tức là chuỗi con liên tiếp vẫn tiếp tục
            if (current.isEmpty() || string.charAt(i) > current.getLast()) {
                current.add(string.charAt(i));
            } else {
                // Nếu không, tìm kiếm các vị trí đã chứa ký tự này
                // và bắt đầu lại chuỗi con từ vị trí tiếp theo
                if (current.contains(string.charAt(i))) {
                    int index = current.indexOf(string.charAt(i));
                    current.subList(0, index + 1).clear(); // Xóa các ký tự trước đó
                }
                current.add(string.charAt(i)); // Nhận thêm ký tự hiện tại
            }

            // Cập nhật chuỗi con dài nhất
            if (current.size() > max.size()) {
                max.clear();
                max.addAll(current);
            }
        }

        // Hiển thị chuỗi liên tiếp dài nhất
        System.out.print("Chuỗi liên tiếp dài nhất là: ");
        for (Character ch : max) {
            System.out.print(ch);
        }
        System.out.println();

        input.close(); // Đóng Scanner
    }
}