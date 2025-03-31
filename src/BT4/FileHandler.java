package BT4;

import java.io.*;

public class FileHandler {
    public static void writeStudentToFile(String filename, Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public static Student readStudentFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println("Đã đọc đối tượng từ file " + filename);
            return (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return null;
        }
    }
}
