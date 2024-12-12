package menu;

import models.Product;
import services.CartManager;
import services.ProductManager;

import java.util.Scanner;

public class CustomerMenu {
    private final ProductManager productManager;
    private final CartManager cartManager;

    public CustomerMenu(ProductManager productManager, CartManager cartManager) {
        this.productManager = productManager;
        this.cartManager = cartManager;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Products and Add to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewAndAddToCart(scanner);
                case 2 -> cartManager.viewCart();
                case 3 -> checkout();
                case 4 -> System.out.println("Exiting Customer Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void viewAndAddToCart(Scanner scanner) {
        productManager.displayProducts(productManager.getProductFromFile());
        System.out.print("Enter product ID to add to cart: ");
        String productId = scanner.nextLine();
        Product product = productManager.getProductFromFile().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter quantity to add to cart: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        cartManager.addToCart(product, quantity);
    }

    private void checkout() {
        double total = cartManager.checkout();
        System.out.printf("Total amount: %.2f\n", total);
        System.out.println("Thank you for shopping with us!");
    }
}
