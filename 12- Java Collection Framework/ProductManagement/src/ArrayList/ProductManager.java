package ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct(int id, String name, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                return;
            }
        }
        System.out.println("ArrayList.Product not found");
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.print(product);
            }
        }
        System.out.print("ArrayList.Product not found");
    }

    public void sortProductsByPriceAscending() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }

    public void sortProductsByPriceDescending() {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }
}
