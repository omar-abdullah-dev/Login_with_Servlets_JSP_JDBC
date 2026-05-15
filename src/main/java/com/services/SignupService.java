package com.services;

import com.dao.UserDAO;
import com.models.ResultModel;
import com.models.User;
// explain the execution flow of this class:
//     1. The `SignupService` class is responsible for handling the user signup process.
//     2. It has a method `signup` that takes the user's email, password, and confirm password as parameters.
//     3. The method first checks if any of the fields are null or empty. If so, it returns a `SignupResult` indicating failure with a message "All fields are required".
//     4. Next, it checks if the password and confirm password match. If they do not match, it returns a `SignupResult` indicating failure with a message "Passwords do not match".
//     5. Then, it checks if a user with the provided email already exists in the database by calling `userDAO.getUserByEmail(email)`. If a user is found, it returns a `SignupResult` indicating failure with a message "Already registered. Please login.".
//     6. If all checks pass, it attempts to insert the new user into the database using `userDAO.insertUser(new User(email, password))`. If the insertion fails, it returns a `SignupResult` indicating failure with a message "Signup failed. Please try again.".
//     7. If the insertion is successful, it returns a `SignupResult` indicating success with a message "Signup successful! Please log in.".

public class SignupService {
    private final UserDAO userDAO = new UserDAO();

    public ResultModel signup(String email, String password, String confirmPassword) {
        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || confirmPassword == null || confirmPassword.trim().isEmpty()) {
            return new ResultModel(false, "All fields are required");
        }

        if (!password.equals(confirmPassword)) {
            return new ResultModel(false, "Passwords do not match");
        }

        if (userDAO.getUserByEmail(email) != null) {
            return new ResultModel(false, "Already registered. Please login.");
        }

        boolean inserted = userDAO.insertUser(new User(email, password));
        if (!inserted) {
            return new ResultModel(false, "Signup failed. Please try again.");
        }

        return new ResultModel(true, "Signup successful! Please log in.");
    }
}