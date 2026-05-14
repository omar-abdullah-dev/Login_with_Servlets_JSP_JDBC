# Login_with_Servlets_JSP_JDBC

## Overview
This is a small Java web app that demonstrates a login flow using:

- Java Servlets + JSP
- JDBC with PostgreSQL
- Maven for build/packaging

A user submits an email and password on `/login`. The server validates against a `users` table and redirects to `home.jsp` on success.

## Features
- Login form (`login.jsp`) with email/password fields
- Servlet mapped to `/login` that handles GET (show form) and POST (authenticate)
- Simple JDBC repository query against `users`
- Home page (`home.jsp`) shown after successful login

## Project Structure (key files)
- `src/main/java/com/controller/LoginServlet.java` - login servlet
- `src/main/java/com/services/AuthService.java` - authentication service
- `src/main/java/com/repos/UserRepo.java` - JDBC access to `users` table
- `src/main/java/com/db/DBConnection.java` - DB connection singleton
- `src/main/webapp/login.jsp` - login form view
- `src/main/webapp/home.jsp` - post-login page
- `pom.xml` - Maven configuration

## Prerequisites
- Java JDK (8+)
- Maven 3.x
- PostgreSQL server
- Servlet container (e.g., Tomcat)

## Database Setup
Default settings are in `src/main/java/com/db/DBConnection.java`.

Example PostgreSQL SQL:

```sql
CREATE DATABASE "LoginServletDB";
\c "LoginServletDB";

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);

INSERT INTO users (email, password)
VALUES ('user@example.com', 'password123');
```

## Build
From the project root:

```powershell
mvn clean package
```

This creates `target/ServletDemo.war`.

## Run / Deploy (Tomcat)
1. Copy `target/ServletDemo.war` to Tomcat `webapps`.
2. Start Tomcat.
3. Open `http://localhost:8080/ServletDemo/login`.

## Endpoints
- GET `/login` - show login page
- POST `/login` - validate credentials and redirect

## Notes / Limitations
- Passwords are stored in plain text (demo only). Use hashing in real apps.
- DB credentials are hard-coded; move to environment variables/config for production.
- No session protection on `home.jsp` yet.

## Troubleshooting
- If DB connection fails, verify URL/username/password and that PostgreSQL is running.
- If JDBC driver errors appear, ensure PostgreSQL dependency is present in `pom.xml`.
