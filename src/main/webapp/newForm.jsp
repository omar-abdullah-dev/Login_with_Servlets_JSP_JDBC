<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New User</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f6f9;
            color: #2c3e50;
        }

        .page {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 24px;
        }

        .card {
            width: 100%;
            max-width: 440px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);
            padding: 28px 30px;
        }

        .card h2 {
            margin: 0 0 18px 0;
            font-size: 24px;
            text-align: center;
        }

        .field {
            margin-bottom: 14px;
            display: flex;
            flex-direction: column;
            gap: 6px;
        }

        label {
            font-size: 13px;
            font-weight: 600;
        }

        input[type="email"],
        input[type="password"] {
            padding: 10px 12px;
            border: 1px solid #d4d9e2;
            border-radius: 6px;
            font-size: 14px;
            outline: none;
        }

        input[type="email"]:focus,
        input[type="password"]:focus {
            border-color: #3498db;
            box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.15);
        }

        .actions {
            margin-top: 18px;
            display: flex;
            gap: 10px;
        }

        button,
        .btn-link {
            width: 100%;
            padding: 11px 14px;
            border: none;
            border-radius: 6px;
            font-weight: 600;
            cursor: pointer;
            font-size: 14px;
            text-align: center;
            text-decoration: none;
        }

        button {
            background: #2ecc71;
            color: #fff;
            transition: background-color 0.2s ease;
        }

        button:hover {
            background: #27ae60;
        }

        .btn-link {
            background: #ecf0f1;
            color: #2c3e50;
        }

        .btn-link:hover {
            background: #dfe6e9;
        }
    </style>
</head>
<body>
<div class="page">
    <div class="card">
        <h2>Add New User</h2>
        <form action="<%= request.getContextPath() %>/users" method="post">
            <input type="hidden" name="action" value="insert">
            <div class="field">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="error"><%= request.getAttribute("errorMessage") %></div>
            <% } %>
            <div class="field">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="actions">
                <button type="submit">Save</button>
                <a class="btn-link" href="<%= request.getContextPath() %>/users?action=list">Cancel</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
