package com.controller;

import com.models.ResultModel;
import com.services.LoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final LoginService loginService=new LoginService();

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
        ResultModel result = loginService.login(email, password);
        if (result.isSuccess()) {
            response.sendRedirect(request.getContextPath() + "/users?action=list");
        } else {
            request.setAttribute("errorMessage", result.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
