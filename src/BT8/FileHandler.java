package BT8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static void writeProductsToFile(String filename, List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(products);
            System.out.println("Danh sách sản phẩm đã được ghi vào file " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static List<Product> readProductsFromFile(String filename) {
        List<Product> products = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return products;
    }
}
