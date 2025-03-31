import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên tệp: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        try {
            if (file.exists()) {
                System.out.println("Tệp đã tồn tại!");
            } else {
                if (file.createNewFile()) {
                    System.out.println("Tệp đã được tạo: " + file.getAbsolutePath());
                } else {
                    System.out.println("Không thể tạo tệp!");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi thao tác với tệp: " + e.getMessage());
        }

        scanner.close();
    }
}
