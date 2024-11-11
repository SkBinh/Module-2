import java.util.Scanner;

public class ChangeValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rate = 23000;
        double usd;
        System.out.println("Enter USD: ");
        usd = scanner.nextDouble();
        double vnd = rate * usd;
        System.out.println("Change: " + vnd + " vnđ" );
    }
}
