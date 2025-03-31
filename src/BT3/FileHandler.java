package BT3;


import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

import java.io.FileReader;
public class FileHandler {
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return content.toString();
    }

    public static void copyFile(String sourceFile, String destFile) {
        String content = readFromFile(sourceFile);
        writeToFile(destFile, content);
    }
}
