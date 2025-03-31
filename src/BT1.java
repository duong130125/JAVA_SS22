import java.io.*;
import java.util.Scanner;

public class BT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "bai1.txt";

        System.out.print("Nhập chuỗi cần ghi vào file: ");
        String userInput = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(userInput);
            System.out.println("Đã ghi vào file: " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        System.out.println("\nNội dung trong file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
