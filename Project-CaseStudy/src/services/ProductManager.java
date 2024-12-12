package services;

import data.FileManager;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ProductManager instance;
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public int getIndexById(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    public List<Product> getProductFromFile() {
        products = new FileManager().getProductsFromFile();
        return products;
    }

    public List<Product> getProducts() {
        return products;
    }



    public void addProduct(Product product) {
        if (Validation.isValidProduct(product)) {
            products.add(product);
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Invalid product details.");
        }
    }

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            products.forEach(System.out::println);
        }
    }

    public void replaceProductsByIndex(int index, Product product) {
        products.set(index, product);
    }
}
