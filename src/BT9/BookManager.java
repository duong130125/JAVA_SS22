package BT9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private final String filename;
    private List<Book> books;

    public BookManager(String filename) {
        this.filename = filename;
        this.books = loadBooksFromFile();
    }

    private List<Book> loadBooksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public void updateBook(int id, String name, String author, String publisher, double price) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setName(name);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setPrice(price);
                saveBooksToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID: " + id);
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
        saveBooksToFile();
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Thư viện trống.");
        } else {
            books.forEach(System.out::println);
        }
    }
}
