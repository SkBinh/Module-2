package data;

import models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {
    private final String PRODUCT_FILE = "C:\\Users\\SkBinh\\Codegym\\module 2\\Project-CaseStudy\\src\\products.txt";
    private final String TEMP_FILE = "C:\\Users\\SkBinh\\Codegym\\module 2\\Project-CaseStudy\\src\\temp.txt";

    public void saveProductToFile(Product product, String type) {
        String productData = ProductMapper.mapToString(product, type);
        FileOperations.writeToFile(PRODUCT_FILE, productData, true);
    }

    public Product loadProductFromFile(String productId) {
        List<String> lines = FileOperations.readFromFile(PRODUCT_FILE);
        for (String line : lines) {
            Product product = ProductMapper.mapToProduct(line);
            if (product != null && product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public String getType(String productId){
        List<String> lines = FileOperations.readFromFile(PRODUCT_FILE);
        for (String line : lines) {
            Product product = ProductMapper.mapToProduct(line);
            if (product != null && product.getId().equals(productId)) {
//                return product.getClass().getSimpleName();
                return line.split(",")[0];
            }
        }
        return null;
    }

    public List<Product> getProductsFromFile() {
        List<String> lines = FileOperations.readFromFile(PRODUCT_FILE);
        List<Product> products = new ArrayList<>();
        for (String line : lines) {
            Product product = ProductMapper.mapToProduct(line);
            if (product != null) {
                products.add(product);
            }
        }
        return products;
    }

    public void replaceFile(List<Product> updatedProducts) {
        List<String> currentLines = FileOperations.readFromFile(PRODUCT_FILE);
        List<String> updatedLines = new ArrayList<>();

        for (String line : currentLines) {
            Product existingProduct = ProductMapper.mapToProduct(line);
            if (existingProduct != null) {
                boolean isUpdated = false;
                for (Product updatedProduct : updatedProducts) {
                    if (updatedProduct.getId().equals(existingProduct.getId())) {
//                        updatedLines.add(ProductMapper.mapToString(updatedProduct, updatedProduct.getClass().getSimpleName()));
                        updatedLines.add(ProductMapper.mapToString(updatedProduct, line.split(",")[0]));
                        isUpdated = true;
                        break;
                    }
                }
                if (!isUpdated) {
                    updatedLines.add(line);
                }
            }
        }

        for (String line : updatedLines) {
            FileOperations.writeToFile(TEMP_FILE, line, true);
        }

        if (FileOperations.replaceFile(TEMP_FILE, PRODUCT_FILE)) {
//            System.out.println("File replaced successfully!");
        }
    }
}
