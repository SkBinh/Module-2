package services;

import models.Product;

public class Validation {
    public static boolean isValidUsername(String username) {
        return username != null && username.matches("^[a-zA-Z0-9]+$");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isValidPrice(double price) {
        return price > 0.0;
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    public static boolean isValidProductName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidProduct(Product product) {
        return isValidProductName(product.getName()) &&
                isValidPrice(product.getPrice()) &&
                isValidQuantity(product.getQuantity());
    }

    public static boolean isValidCart(int quantity, Product product) {
        return quantity > 0 && quantity <= product.getQuantity();
    }
}
