package BT10;

import java.util.List;
import java.util.Scanner;

public class BT10 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        String filename = "students.dat";
        Scanner scanner = new Scanner(System.in);

        manager.loadFromFile(filename);

        while (true) {
            System.out.println("\n--- Quản lý Sinh viên ---");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm sinh viên có GPA cao nhất");
            System.out.println("4. Tìm sinh viên theo chuyên ngành");
            System.out.println("5. Tính điểm trung bình GPA");
            System.out.println("6. Lưu danh sách vào file");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập chuyên ngành: ");
                    String major = scanner.nextLine();
                    System.out.print("Nhập GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();
                    manager.addStudent(new Student(id, name, major, gpa));
                    break;
                case 2:
                    manager.displayAllStudents();
                    break;
                case 3:
                    Student topStudent = manager.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Sinh viên có GPA cao nhất: " + topStudent);
                    } else {
                        System.out.println("Danh sách trống.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập chuyên ngành cần tìm: ");
                    String searchMajor = scanner.nextLine();
                    List<Student> foundStudents = manager.searchByMajor(searchMajor);
                    if (foundStudents.isEmpty()) {
                        System.out.println("Không có sinh viên nào thuộc chuyên ngành này.");
                    } else {
                        foundStudents.forEach(System.out::println);
                    }
                    break;
                case 5:
                    System.out.printf("Điểm GPA trung bình: %.2f\n", manager.calculateAverageGpa());
                    break;
                case 6:
                    manager.saveToFile(filename);
                    System.out.println("Đã lưu danh sách vào file.");
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
