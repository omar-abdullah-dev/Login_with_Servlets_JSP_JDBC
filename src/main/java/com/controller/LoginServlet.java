package com.controller;

import com.db.DBConnection;
import com.services.AuthService;

/**
 * Servlet implementation class LoginServlet
 *  1- form of login data has email, password
 *  2- button in the login page --> to proceed the login request calling LoginServlet
 *  3-  in the doPost method, we need to validate the input and check if the user exists in the database
 *  4- if the user exists, redirect to home page
 *  5- if the user does not exist, show an error message
 *  6- we need to create a service class for login to handle the business logic of login
 *      and to separate the concerns of the servlet and the service class
 *  7- in the service class, we need to call the repo class to check if the user exists in the database(DB Interaction)
 *  8- if the user exists, return true(redirect to home page of users), otherwise return false
 *  9- in the servlet, we need to call the service class to check if the user exists and redirect accordingly
 *
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AuthService loginService=new AuthService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        boolean isValid = loginService.Login(email,password);
        if (isValid) {
            response.sendRedirect(request.getContextPath() + "/users?action=list");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
