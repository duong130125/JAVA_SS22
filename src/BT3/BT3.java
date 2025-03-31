package BT3;

import java.util.Scanner;

public class BT3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile = "input.txt";
        String copyFile = "copy.txt";

        System.out.print("Nhập nội dung để ghi vào file input.txt: ");
        String content = scanner.nextLine();
        FileHandler.writeToFile(inputFile, content);

        FileHandler.copyFile(inputFile, copyFile);

        System.out.println("\nNội dung file copy.txt:");
        System.out.println(FileHandler.readFromFile(copyFile));
    }
}
