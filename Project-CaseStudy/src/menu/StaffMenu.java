package menu;

import data.FileManager;
import models.Product;
import models.ProductFactory;
import services.ProductManager;

import java.util.Scanner;

public class StaffMenu {
    private final ProductManager productManager;

    public StaffMenu(ProductManager productManager) {
        this.productManager = productManager;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nStaff Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Exit");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> productManager.displayProducts(productManager.getProductFromFile());
                case 2 -> addProduct(scanner);
                case 3 -> System.out.println("Exiting Staff Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void addProduct(Scanner scanner) {
        System.out.println("Enter product type: ");
        String type = scanner.nextLine();
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product;
        try {
            product = ProductFactory.createProduct(type, id, name, description, price, quantity);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        new FileManager().saveProductToFile(product, type);
    }
}
