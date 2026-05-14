package com.controller;

import com.db.DBConnection;
import com.services.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  AuthService loginService=new AuthService();
    DBConnection db=DBConnection.getInstance();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        boolean isValid = loginService.Login(email,password);
        if (isValid) {
            response.sendRedirect("home.jsp");
        } else {
            response.getWriter().println("Invalid email or password");
            response.sendRedirect(
                    request.getContextPath()
                            + "/login.jsp?error=Invalid email or password"
            );
        }
    }
}
