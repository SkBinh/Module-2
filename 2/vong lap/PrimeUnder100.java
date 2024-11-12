import java.util.Scanner;

public class PrimeUnder100 {
    public static void main(String[] args) {
        System.out.println("Số Nguyên tố dưới 100: ");
        for (int i = 2; i < 100; i++){
            if (isPrime(i)){
                System.out.print(i + " ");
            }
        }
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
