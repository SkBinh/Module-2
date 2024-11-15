import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number a:");
        double a = scanner.nextDouble();
        System.out.print("Enter number b:");
        double b = scanner.nextDouble();
        System.out.print("Enter number c:");
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();

        if (delta > 0){
            System.out.println("The equation has two roots: " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("The equation has one root: " + equation.getRoot1());
        } else {
            System.out.print("The equation has no roots");
        }
    }
}
