package BT6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Đã ghi vào file: " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static String readFromFile(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return "";
        }
    }
}
