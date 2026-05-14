# Login_with_Servlets_JSP_JDBC

## Overview
This is a small Java web app that demonstrates login and basic user management using:

- Java Servlets + JSP
- JDBC with PostgreSQL
- Maven for build/packaging

The app includes a login flow (`/login`) and a CRUD-style user management UI (`/users?action=list`) rendered in `home.jsp`.

## Features
- Login form (`login.jsp`) with email/password fields
- Login servlet mapped to `/login`
- Users management (list, add, edit, delete) via `/users` controller
- JDBC DAO operations against the `users` table
- Styled user table in `home.jsp`

## Project Structure (key files)
- `src/main/java/com/controller/LoginServlet.java` - login servlet
- `src/main/java/com/controller/UserServlet.java` - users CRUD controller (`/users`)
- `src/main/java/com/services/AuthService.java` - authentication service
- `src/main/java/com/dao/UserDAO.java` - user DAO (CRUD)
- `src/main/java/com/db/DBConnection.java` - DB connection singleton
- `src/main/webapp/login.jsp` - login form view
- `src/main/webapp/home.jsp` - users list UI
- `src/main/webapp/newForm.jsp` - add user form
- `src/main/webapp/editForm.jsp` - edit user form
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
3. Open the app:
   - Login: `http://localhost:8080/ServletDemo/login`
   - Users list: `http://localhost:8080/ServletDemo/users?action=list`

Note: If you deploy as an exploded WAR (e.g., `ServletDemo_war_exploded`), use that context path instead.

## Endpoints
- GET `/login` - show login page
- POST `/login` - validate credentials and redirect
- GET `/users?action=list` - list users (home page)
- GET `/users?action=new` - show add form
- POST `/users` with `action=insert` - create user
- GET `/users?action=edit&id={id}` - show edit form
- POST `/users` with `action=update` - update user
- GET `/users?action=delete&id={id}` - delete user

## Notes / Limitations
- Passwords are stored in plain text (demo only). Use hashing in real apps.
- DB credentials are hard-coded; move to environment variables/config for production.
- No session protection on `home.jsp` yet.

## Troubleshooting
- If DB connection fails, verify URL/username/password and that PostgreSQL is running.
- If JDBC driver errors appear, ensure PostgreSQL dependency is present in `pom.xml`.
- If you see the welcome page instead of the users list, open `/users?action=list` directly or redeploy the WAR.
