package com.bookstore.controller;
import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
 String action = request.getParameter("action");
 BookDAO dao = new BookDAO();
 HttpSession session = request.getSession();
 if ("search".equals(action)) {
 String query = request.getParameter("query");
 List<Book> books = dao.searchBooks(query);
 request.setAttribute("bookList", books);
 request.getRequestDispatcher("index.jsp").forward(request, response);

 } else if ("add".equals(action)) {
 int id = Integer.parseInt(request.getParameter("id"));
 List<Book> cart = (List<Book>) session.getAttribute("cart");
 if (cart == null) cart = new ArrayList<>();

 // Logic to find and add book (Simulated)
 for(Book b : dao.getAllBooks()) {
 if(b.getId() == id) cart.add(b);
 }

 session.setAttribute("cart", cart);
 response.sendRedirect("index.jsp?msg=AddedToCart");
 }
 }
}
