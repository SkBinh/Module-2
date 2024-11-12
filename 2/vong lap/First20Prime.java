import java.util.Scanner;

public class First20Prime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số lượng số nguyên tố cần in ra: ");
        int number = input.nextInt();
        int count = 0;
        int N = 2;

        System.out.println("Các số nguyên tố đầu tiên là: ");
        while (count < number) {
            if (isPrime(N)) {
                System.out.print(N + " ");
                count++;
            }
            N++;
        }
        input.close();
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
