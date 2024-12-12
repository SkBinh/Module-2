package models;

public class ProductFactory {
    public static Product createProduct(String productType, String id, String name, String description, double price, int quantity) {
        switch (productType) {
            case "Clothing":
                return new ClothingProduct(id, name, description, price, quantity);
            case "Food":
                return new FoodProduct(id, name, description, price, quantity);
            case "Electronic":
                return new ElectronicProduct(id, name, description, price, quantity);
            default:
                throw new IllegalArgumentException("Invalid product type: " + productType);
        }
    }
}
