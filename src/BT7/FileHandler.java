package BT7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<Country> readCountriesFromFile(String filename) {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].trim();
                    String name = parts[2].trim();
                    countries.add(new Country(id, code, name));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return countries;
    }

    public static void writeSampleData(String filename) {
        String sampleData = "1,VN,Vietnam\n2,US,United States\n3,JP,Japan\n4,FR,France\n5,DE,Germany";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(sampleData);
            System.out.println("Dữ liệu đã được ghi vào file " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
