package BT5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static void writeToFile(String filename, List<String> names) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("Đã ghi danh sách cầu thủ vào file " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static List<String> readFromFile(String filename) {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return names;
    }
}
