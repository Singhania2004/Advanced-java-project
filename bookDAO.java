package com.bookstore.dao;
import com.bookstore.model.Book;
import java.util.ArrayList;
import java.util.List;
public class BookDAO {
 // Simulated JDBC Connection Properties
 private String url = "jdbc:mysql://localhost:3306/bookstore_db";
 private String user = "root";
 private String pass = "admin123";
 public List<Book> getAllBooks() {
 // Simulating: SELECT * FROM books
 List<Book> books = new ArrayList<>();
 books.add(new Book(101, "Java Basics: A Beginner's Guide", "Herbert Schildt", 450.00));
 books.add(new Book(102, "Advanced C++ Concepts", "Bjarne Stroustrup", 550.00));
 books.add(new Book(103, "Database Management Systems", "Ramakrishnan", 600.00));
 books.add(new Book(104, "Web Tech with JSP/Servlets", "Sameer", 320.00));
 return books;
 }
 public List<Book> searchBooks(String keyword) {
 // Simulating: SELECT * FROM books WHERE title LIKE ?
 List<Book> all = getAllBooks();
 if (keyword == null || keyword.isEmpty()) return all;

 List<Book> results = new ArrayList<>();
 for (Book b : all) {
 if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
 results.add(b);
 }
 }
 return results;
 }
}
