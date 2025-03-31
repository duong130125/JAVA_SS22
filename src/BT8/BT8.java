package BT8;

import java.util.ArrayList;
import java.util.List;

public class BT8 {
    public static void main(String[] args) {
        String filename = "products.dat";

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop Dell", 1500.99));
        products.add(new Product(2, "iPhone 14", 999.49));
        products.add(new Product(3, "Samsung Galaxy", 899.99));
        products.add(new Product(4, "MacBook Pro", 2500.00));
        products.add(new Product(5, "AirPods Pro", 249.99));

        FileHandler.writeProductsToFile(filename, products);

        List<Product> readProducts = FileHandler.readProductsFromFile(filename);

        System.out.println("Danh sách sản phẩm:");
        for (Product product : readProducts) {
            System.out.println(product);
        }
    }
}
