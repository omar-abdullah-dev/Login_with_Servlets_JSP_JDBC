<%@ page import="java.util.List" %>
<%@ page import="com.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Management Table</title>
    <style>
        /* Table Layout Styling */
        .table-container {
            width: 90%;
            margin: 30px auto;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            background-color: #fff;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #dddddd;
        }

        th {
            background-color: #2c3e50;
            color: white;
            text-transform: uppercase;
            font-size: 14px;
            letter-spacing: 0.5px;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        /* Action Buttons Wrapper */
        .action-buttons {
            display: flex;
            gap: 8px;
        }

        /* Core Button Styles */
        .btn {
            padding: 8px 14px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: 600;
            font-size: 13px;
            transition: background-color 0.2s ease;
            text-decoration: none;
            display: inline-block;
        }

        /* Specific Button Types */
        .btn-edit {
            background-color: #3498db;
            color: white;
        }

        .btn-edit:hover {
            background-color: #2980b9;
        }

        .btn-delete {
            background-color: #e74c3c;
            color: white;
        }

        .btn-delete:hover {
            background-color: #c0392b;
        }

        /* Add Button Footer Row styling */
        .table-footer {
            margin-top: 15px;
            display: flex;
            justify-content: flex-end; /* Aligns the add button to the right */
        }

        .btn-add {
            background-color: #2ecc71;
            color: white;
            padding: 10px 20px;
            font-size: 14px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .btn-add:hover {
            background-color: #27ae60;
        }

        /* Password masking for security visualization */
        .password-cell {
            font-family: monospace;
            letter-spacing: 2px;
        }
    </style>

</head>
<body>

    <div class="table-container">
        <h2>Users Registry</h2>

        <table>
        <%-- the Header of the table --%>
            <thead>
            <tr>
                <th>ID</th>
                <th>Email Address</th>
                <th>Password</th>
                <th>Operations</th>
            </tr>
            </thead>

            <tbody>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null) {
                    for (User user : users) {
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getEmail() %></td>
                <td class="password-cell">••••••••</td>
                <td>
                    <div class="action-buttons">
                        <a href="<%= request.getContextPath() %>/users?action=edit&id=<%= user.getId() %>" class="btn btn-edit">Edit</a>
                        <a href="<%= request.getContextPath() %>/users?action=delete&id=<%= user.getId() %>" class="btn btn-delete" onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                    </div>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>

        <!-- Add button container at the end of the table -->
        <div class="table-footer">
            <a href="<%= request.getContextPath() %>/users?action=new" class="btn btn-add">+ Add New User</a>
        </div>
    </div>

</body>
</html>
