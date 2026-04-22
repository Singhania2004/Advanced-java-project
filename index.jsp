<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <title>Online Bookstore - JSP/Servlet/JDBC</title>
 <style>
 body { font-family: "Times New Roman", serif; background: #f0f0f0; padding: 20px; }
 .container { background: white; border: 1px solid #999; width: 80%; margin: auto; padding:
20px; box-shadow: 5px 5px 10px #888; }
 .navbar { background: #003366; color: white; padding: 10px; display: flex; justify-content:
space-between; }
 table { width: 100%; border-collapse: collapse; margin-top: 20px; }
 th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
 th { background: #eee; }
 .btn { background: #febd69; padding: 5px 10px; border: 1px solid #a88734; cursor: pointer;
}
 </style>
</head>
<body>
<div class="container">
 <div class="navbar">
 <span>Welcome, <b>Sameer</b> (Port: 8080)</span>
 <span>Cart Items: ${cart != null ? cart.size() : 0}</span>
 </div>
 <h1>Bookstore Inventory</h1>
 <form action="BookServlet" method="get">
 <input type="hidden" name="action" value="search">
 <b>JDBC Search:</b> <input type="text" name="query" placeholder="Enter title...">
 <input type="submit" value="Execute Query" class="btn">
 </form>
 <table>
 <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Action</th></tr>
 <c:forEach var="book" items="${bookList}">
 <tr>
 <td>${book.id}</td>
 <td><b>${book.title}</b></td>
 <td>${book.author}</td>
 <td>INR ${book.price}</td>
 <td><a href="BookServlet?action=add&id=${book.id}"><button class="btn">Add to
Cart</button></a></td>
 </tr>
 </c:forEach>
 </table>
 <c:if test="${not empty cart}">
 <h3>Your Shopping Cart (Session Data)</h3>
 <table>
 <tr><th>Title</th><th>Price</th></tr>
 <c:forEach var="item" items="${cart}">
 <tr><td>${item.title}</td><td>${item.price}</td></tr>
 </c:forEach>
 </table>
 </c:if>
</div>
</body>
</html>