package services;

import data.FileManager;
import models.CartItem;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private List<CartItem> cart;
    private static CartManager instance;

    public CartManager() {
        this.cart = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(Product product, int quantity) {
        if (Validation.isValidCart(quantity, product)) {
            product.setQuantity(product.getQuantity() - quantity);
            cart.add(new CartItem(product, quantity));
            System.out.println(quantity + " " + product.getName() + " added to the cart.");
        } else {
            System.out.println("Invalid quantity or product not available.");
        }
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (CartItem item : cart) {
                System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity());
            }
        }
    }

    public double checkout() {
        double total = 0;
        System.out.println("Cart before checkout: ");
        for (CartItem product : cart) {
            System.out.println("========================================");
            System.out.println("Product name: " + product.getProduct().getName());
            System.out.println("Product price: " + product.getProduct().getPrice());
            System.out.println("Product quantity: " + product.getQuantity());
            System.out.println();
            total += product.getPrice() * product.getQuantity();
        }
        List<Product> products = new ArrayList<>();
        for (CartItem item : cart) {
            products.add(item.getProduct());
        }

        new FileManager().replaceFile(products);
        cart.clear();
        return total;
    }
}
