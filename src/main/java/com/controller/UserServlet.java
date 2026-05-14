package com.controller;

import com.dao.UserDAO;
import com.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO dao ;
    public UserServlet() {
        dao = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(req,resp);
                break;
            case "insert":
                try {
                    insertUser(req,resp);
                } catch (ServletException | IOException e) {
                    System.out.println("An error occurred during inserting user: " + e.getMessage());
                    e.printStackTrace();
                }
                break;
            case "update":
                updateUser(req,resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;
            case "edit":
                editUser(req,resp);
                break;
            default:
                listUser(req,resp);
                break;
        }
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",dao.getAllUsers());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/newForm.jsp");
        requestDispatcher.forward(req,resp);
    }
    private void insertUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(0, email,password);
        dao.insertUser(user);
        resp.sendRedirect(req.getContextPath() + "/users?action=list");
    }
     private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id = Integer.parseInt(req.getParameter("id"));
         String email = req.getParameter("email");
         String password = req.getParameter("password");
         User existingUser = dao.getUserById(id);
         if (email == null || email.trim().isEmpty()) {
             email = existingUser.getEmail();
         }
         if (password == null || password.trim().isEmpty()) {
             password = existingUser.getPassword();
         }
         User user = new User(id, email,password);
         dao.updateUserInfo(user);
         resp.sendRedirect(req.getContextPath() + "/users?action=list");
    }
     private void deleteUser(HttpServletRequest req, HttpServletResponse resp)
             throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        dao.deleteUserById(id);
        resp.sendRedirect(req.getContextPath() + "/users?action=list");

    }
     private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id = Integer.parseInt(req.getParameter("id"));
         User existingUser = dao.getUserById(id);
         req.setAttribute("user", existingUser);
         RequestDispatcher requestDispatcher = req.getRequestDispatcher("/editForm.jsp");
         requestDispatcher.forward(req,resp);
    }
}
