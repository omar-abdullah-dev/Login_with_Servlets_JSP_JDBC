<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 5/14/2026
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
    <h2>Add New User</h2>
    <form action="<%= request.getContextPath() %>/users" method="post">
        <input type="hidden" name="action" value="insert">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">Save</button>
    </form>
</body>
</html>
