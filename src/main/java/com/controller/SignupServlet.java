package com.controller;

// Update Notes (2026-05-15):
// - Keep server-side validation here.
// - Forward to /users with query parameters so UserServlet handles insert.

import com.dao.UserDAO;
import com.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * we need to create a servlet for signup
 * 1- button on login page to redirect to signup page
 * 2- signup form containing email, password, confirm password
 * 3- signup button redirecting to signup servlet
 * 4- in signup servlet, we need to validate the input and create a new user
 * 5- if the user is created successfully, redirect to login page with a success message
 * 6- if the user is not created successfully, redirect to signup page with an error message
 *
* */

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || confirmPassword == null || confirmPassword.trim().isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        UserDAO userDAO = new UserDAO();
        User isExist=userDAO.getUserByEmail(email);
        if(isExist!=null){
            request.setAttribute("errorMessage", "already registered. Please try to login.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        boolean isInserted = userDAO.insertUser(new User(email, password));
        if (isInserted) {
            String successMessage = "Signup successful! Please log in.";
            response.sendRedirect(request.getContextPath()+ "/login");
        } else {
            request.setAttribute("errorMessage", "Signup failed. Please try again.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }


    }
}
