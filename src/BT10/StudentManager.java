package BT10;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            students = new ArrayList<>();
        }
    }

    public Student findTopStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);
    }

    public List<Student> searchByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public double calculateAverageGpa() {
        return students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            students.forEach(System.out::println);
        }
    }
}
