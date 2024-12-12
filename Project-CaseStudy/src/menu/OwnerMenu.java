package menu;

import data.FileManager;
import models.Product;
import models.ProductFactory;
import services.ProductManager;

import java.util.Scanner;

public class OwnerMenu {
    private final ProductManager productManager;

    public OwnerMenu(ProductManager productManager) {
        this.productManager = productManager;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nOwner Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Edit Product");
            System.out.println("4. Exit");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> productManager.displayProducts(productManager.getProductFromFile());
                case 2 -> addProduct(scanner);
                case 3 -> editProduct(scanner);
                case 4 -> System.out.println("Exiting Owner Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
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
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        new FileManager().saveProductToFile(product, type);
    }

    private void editProduct(Scanner scanner) {
        System.out.print("Enter product ID to edit: ");
        String id = scanner.nextLine();
//        Product product = productManager.getProducts().stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst()
//                .orElse(null);

        Product product = new FileManager().loadProductFromFile(id);
        String productType = new FileManager().getType(id);

        productManager.getProductFromFile();
        int index = productManager.getIndexById(id);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter new name (current: " + product.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) product.setName(name);

        System.out.print("Enter new description (current: " + product.getDescription() + "): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) product.setDescription(description);

        System.out.print("Enter new price (current: " + product.getPrice() + "): ");
        double price = scanner.nextDouble();
        if (price > 0) product.setPrice(price);

        System.out.print("Enter new quantity (current: " + product.getQuantity() + "): ");
        int quantity = scanner.nextInt();
        if (quantity >= 0) product.setQuantity(quantity);

        productManager.replaceProductsByIndex(index, product);

        new FileManager().replaceFile(productManager.getProducts());
        System.out.println("Product updated successfully.");
    }
}
