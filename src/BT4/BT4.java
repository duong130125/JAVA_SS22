package BT4;

public class BT4 {
    public static void main(String[] args) {
        String filename = "student.dat";
        Student student = new Student("NguyenVanA", 100, 8.5);

        FileHandler.writeStudentToFile(filename, student);

        Student readStudent = FileHandler.readStudentFromFile(filename);
        if (readStudent != null) {
            System.out.println("Thông tin sinh viên: " + readStudent);
        }
    }
}
