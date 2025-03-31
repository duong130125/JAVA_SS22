package BT9;

import java.util.Scanner;

public class BT9 {
    public static void main(String[] args) {
        BookManager manager = new BookManager("books.dat");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Quản lý thư viện ---");
            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhật sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Hiển thị danh sách sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String author = scanner.nextLine();
                    System.out.print("Nhập nhà xuất bản: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    manager.addBook(new Book(id, name, author, publisher, price));
                    break;
                case 2:
                    System.out.print("Nhập ID sách cần cập nhật: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhập tác giả mới: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Nhập nhà xuất bản mới: ");
                    String newPublisher = scanner.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    manager.updateBook(updateId, newName, newAuthor, newPublisher, newPrice);
                    break;
                case 3:
                    System.out.print("Nhập ID sách cần xóa: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteBook(deleteId);
                    break;
                case 4:
                    manager.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
