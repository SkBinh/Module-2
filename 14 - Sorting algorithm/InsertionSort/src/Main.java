import java.util.Scanner;

public class Main {

    // Hàm thực hiện sắp xếp chèn
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử arr[0..i-1] lớn hơn key lên một vị trí phía trước
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            // Hiển thị trạng thái mảng sau mỗi lần chèn
            displayArray(arr, i);
        }
    }

    // Hàm hiển thị mảng
    public static void displayArray(int[] arr, int step) {
        System.out.print("Bước " + step + ": ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu: ");
        displayArray(arr, 0);

        // Thực hiện sắp xếp và hiển thị
        insertionSort(arr);

        System.out.println("Mảng đã sắp xếp: ");
        displayArray(arr, n);  // Hiển thị trạng thái cuối cùng của mảng

        scanner.close();
    }
}