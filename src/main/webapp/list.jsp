<%@ page import="com.models.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
    <h2>Users</h2>
    <p><a href="<%= request.getContextPath() %>/users?action=new">Add New User</a></p>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            if (users != null) {
                for (User user : users) {
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getEmail() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/users?action=edit&id=<%= user.getId() %>">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="<%= request.getContextPath() %>/users?action=delete&id=<%= user.getId() %>">Delete</a>
                </td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
