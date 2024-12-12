package data;

import models.Product;
import models.ProductFactory;

public class ProductMapper {
    public static Product mapToProduct(String line) {
        String[] parts = line.split(",");
        if (parts.length != 6) {
            return null;
        }
        try {
            return ProductFactory.createProduct(
                    parts[0], parts[1], parts[2], parts[3],
                    Double.parseDouble(parts[4]), Integer.parseInt(parts[5])
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong product type!");
        }
        return null;
    }

    public static String mapToString(Product product, String type) {
        return type + "," + product.getId() + "," + product.getName() + "," +
                product.getDescription() + "," + product.getPrice() + "," +
                product.getQuantity();
    }
}
