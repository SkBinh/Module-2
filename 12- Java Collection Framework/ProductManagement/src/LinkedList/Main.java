package LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Add ArrayList.Product");
            System.out.println("2. Edit ArrayList.Product");
            System.out.println("3. Remove ArrayList.Product");
            System.out.println("4. Display Products");
            System.out.println("5. Search ArrayList.Product");
            System.out.println("6. Sort Products by Price (Ascending)");
            System.out.println("7. Sort Products by Price (Descending)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(id, name, price);
                    manager.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter product ID to edit: ");
                    id = scanner.nextInt();
                    System.out.print("Enter new product name: ");
                    name = scanner.next();
                    System.out.print("Enter new product price: ");
                    price = scanner.nextDouble();
                    manager.editProduct(id, name, price);
                    break;
                case 3:
                    System.out.print("Enter product ID to remove: ");
                    id = scanner.nextInt();
                    Product productToRemove = new Product(id, "", 0.0);
                    manager.removeProduct(productToRemove);
                    break;
                case 4:
                    manager.displayProducts();
                    break;
                case 5:
                    System.out.print("Enter product name to search: ");
                    name = scanner.next();
                    manager.searchProduct(name);
                    break;
                case 6:
                    manager.sortProductsByPriceAscending();
                    break;
                case 7:
                    manager.sortProductsByPriceDescending();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}