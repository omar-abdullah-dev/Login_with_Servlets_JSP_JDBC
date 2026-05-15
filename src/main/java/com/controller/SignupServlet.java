package com.controller;

import com.models.ResultModel;
import com.services.SignupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private final SignupService signupService = new SignupService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        ResultModel result = signupService.signup(email, password, confirmPassword);

        if (result.isSuccess()) {
            request.setAttribute("signupResult", result);
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setAttribute("errorMessage", result.getMessage());
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
}