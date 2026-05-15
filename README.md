# Login_with_Servlets_JSP_JDBC

## Overview
A Java web app for login and user management using Servlets, JSP, and JDBC with PostgreSQL.
It includes authentication (login/signup) and CRUD operations for users.

## What’s Updated
- CRUD flow through `UserServlet` (`/users`) with list/add/edit/delete.
- Styled, centered UI for login, signup, add, and edit forms.
- Client-side password confirmation validation on signup.
- Login redirects to `/users?action=list` so `home.jsp` shows users.
- Duplicate email handling for signup and add-new using service + DAO check.
- Error messages rendered in login and signup forms.
- DAO fixes for correct `ResultSet` usage and inserts.

## Features
- Login with email/password
- Signup with confirmation + validation
- Users list (home table)
- Add new user
- Edit existing user (leave password blank to keep old)
- Delete user

## Project Structure (Key Files)
- `src/main/java/com/controller/LoginServlet.java` - login controller
- `src/main/java/com/controller/SignupServlet.java` - signup controller
- `src/main/java/com/controller/UserServlet.java` - CRUD controller
- `src/main/java/com/services/AddNewService.java` - add-user business logic
- `src/main/java/com/dao/UserDAO.java` - JDBC CRUD
- `src/main/webapp/login.jsp` - login UI
- `src/main/webapp/signup.jsp` - signup UI
- `src/main/webapp/home.jsp` - users list
- `src/main/webapp/newForm.jsp` - add form
- `src/main/webapp/editForm.jsp` - edit form

## Endpoints
- GET `/login` - show login page
- POST `/login` - authenticate
- POST `/signup` - register new user
- GET `/users?action=list` - list users
- GET `/users?action=new` - show add form
- POST `/users?action=insert` - create user
- GET `/users?action=edit&id={id}` - show edit form
- POST `/users?action=update` - update user
- GET `/users?action=delete&id={id}` - delete user

## Design Patterns Used
- **MVC (Model–View–Controller)**
  - Model: `User` + `UserDAO`
  - View: JSP files
  - Controller: Servlets (`LoginServlet`, `SignupServlet`, `UserServlet`)
- **DAO (Data Access Object)**
  - `UserDAO` encapsulates all DB operations.
- **Service Layer**
  - `AddNewService` (and similar patterns for login/signup) contain business rules.
- **Front Controller (lightweight)**
  - `UserServlet` routes CRUD actions based on `action` parameter.

## Principles Applied
- **Separation of Concerns**
  - Servlets handle HTTP, services handle logic, DAO handles DB.
- **Single Responsibility**
  - Each class has one primary purpose (controller vs. service vs. DAO).
- **DRY**
  - Shared user-creation logic is centralized in service/DAO.
- **Fail Fast / Validation**
  - Input checks before DB insert, user-friendly errors.

## Build & Run
```powershell
mvn clean package
```
Deploy `target/ServletDemo.war` to Tomcat and open:
- `http://localhost:8080/ServletDemo/login`
- `http://localhost:8080/ServletDemo/users?action=list`

## Notes
- Passwords are stored in plain text (demo only). Use hashing in production.
- Ensure `users.email` has a UNIQUE constraint in your DB.
