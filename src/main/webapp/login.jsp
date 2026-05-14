<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>

</head>

<body>

<div class="login-container">

    <h2>Login</h2>

    <form action="login" method="post">

        <div class="input-group">

            <label for="email">Email:</label>

            <input type="text"
                   id="email"
                   name="email"
                   required>
        </div>

        <div class="input-group">

            <label for="password">Password:</label>

            <input type="password"
                   id="password"
                   name="password"
                   required>
        </div>

        <button type="submit">
            Login
        </button>

    </form>

</div>

</body>
</html>