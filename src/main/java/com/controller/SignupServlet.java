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
//  what is the difference between getRequestDispatcher("/login") and getRequestDispatcher("/login.jsp")?
//    1-    getRequestDispatcher("/login") will forward the request to the LoginServlet,
//        which will then handle the request and forward it to the login.jsp page.
//        This allows you to reuse the logic in the LoginServlet,
//        such as setting any necessary attributes or handling any additional processing before displaying the login page.
//    2-    getRequestDispatcher("/login.jsp") will directly forward the request to the login.jsp page without going through the LoginServlet.
//        This means that any logic or processing that is handled in the LoginServlet will be bypassed, and the login.jsp page will be displayed directly.
//        In general, using getRequestDispatcher("/login") is a better approach as it allows for better separation of concerns and promotes code reuse.

//
//  why it moves to http://localhost:8080/ServletDemo_war_exploded/users?action=list after signup?
//    This happens because after a successful signup,
//    the SignupServlet forwards the request to the LoginServlet
//    using request.getRequestDispatcher("/login").forward(request, response).
//    The LoginServlet then processes the login request and, upon successful login,
//    redirects the user to the users list page using:
//    response.sendRedirect(request.getContextPath() + "/users?action=list").
//    This is a common pattern in web applications where after a successful signup,
//    the user is automatically logged in and redirected to the main page of the application.

//        what if i need to move from signup to login servlet and showing login page after successful signup?
//        In that case, you can simply forward the request to the LoginServlet after a successful signup.
//        by using request.getRequestDispatcher("/login").forward(request, response);
//        This will allow you to reuse the logic in the LoginServlet and display the login page directly after a successful signup without needing to redirect the user.
//        but i already made this and not properly working!
//        If the forwarding to the LoginServlet is not working as expected, there could be a few reasons for this:
//        1. Make sure that the LoginServlet is properly mapped in your web.xml or using the @WebServlet annotation.
//        2. Check if there are any exceptions being thrown in the LoginServlet that might be preventing it from processing the request correctly.
//        3. Ensure that the LoginServlet is correctly handling the forwarded request and is forwarding to the login.jsp page as expected.
//        4. Verify that the login.jsp page is located in the correct directory and is accessible by the LoginServlet.
//        5. Check the server logs for any error messages that might provide more insight into why the forwarding is not working as expected.
//        If you are still having trouble, you can try adding some debug statements in both the SignupServlet and LoginServlet to see where the issue might be occurring and to ensure that the request is being forwarded correctly.
        if (result.isSuccess()) {
            request.setAttribute("signupResult", result);
//            we can use the same login servlet logic by calling it using request dispatcher
            request.getRequestDispatcher("/login.jsp").forward(request, response);
//            or we can redirect to the login page using sendRedirect
//            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setAttribute("errorMessage", result.getMessage());
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
}