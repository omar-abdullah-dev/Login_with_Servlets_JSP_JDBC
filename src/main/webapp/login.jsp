<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
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
            max-width: 420px;
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

        input[type="text"],
        input[type="password"] {
            padding: 10px 12px;
            border: 1px solid #d4d9e2;
            border-radius: 6px;
            font-size: 14px;
            outline: none;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #3498db;
            box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.15);
        }

        .actions {
            margin-top: 18px;
        }

        button {
            width: 100%;
            padding: 11px 14px;
            border: none;
            border-radius: 6px;
            background: #3498db;
            color: #fff;
            font-weight: 600;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.2s ease;
        }

        button:hover {
            background: #2980b9;
        }

        .footer-link {
            margin-top: 16px;
            text-align: center;
            font-size: 13px;
        }

        .footer-link a {
            color: #3498db;
            text-decoration: none;
            font-weight: 600;
        }

        .footer-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
<div class="page">
    <div class="card">
        <h2>Login</h2>

        <form action="login" method="post">
            <div class="field">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" required>
            </div>

            <div class="field">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div class="actions">
                <button type="submit">Login</button>
            </div>
        </form>

        <div class="footer-link">
            <span>Don't have an account? </span>
            <a href="signup.jsp">Signup here</a>.
        </div>
    </div>
</div>
</body>

</html>