<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 5/14/2026
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <% User user = (User) request.getAttribute("user"); %>
    <form action="<%= request.getContextPath() %>/users" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= user.getEmail() %>">
        <br>
        <label for="password">New Password:</label>
        <input type="password" id="password" name="password" placeholder="Leave blank to keep current password">
        <br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
