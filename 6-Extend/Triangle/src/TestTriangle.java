import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter side 1: ");
        double side1 = scanner.nextDouble();
        System.out.println("Enter side 2: ");
        double side2 = scanner.nextDouble();
        System.out.println("Enter side 3: ");
        double side3 = scanner.nextDouble();

        System.out.print("Enter color: ");
        String color = scanner.next();

        System.out.print("Triangle is filled? (True/False)");
        boolean filled = scanner.nextBoolean();

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println("\nTriangle:");
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println(triangle.toString());
    }
}
