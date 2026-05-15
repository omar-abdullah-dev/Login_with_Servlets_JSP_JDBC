package com.services;

import com.dao.UserDAO;
import com.models.ResultModel;
import com.models.User;

public class AddNewService {
   private final UserDAO userDAO = new UserDAO();
   public ResultModel addNewUser(String email,String password){
       if (email != null && !email.trim().isEmpty() && password != null && !password.trim().isEmpty()){
           User existingUser = userDAO.getUserByEmail(email);
           if (existingUser!=null){
               return new ResultModel(false, "Email already exists");
           }else {
               boolean inserted = userDAO.insertUser(new User(email, password));
               if (!inserted) {
                   return new ResultModel(false, "Failed to add new user. Please try again.");
               }
               return new ResultModel(true, "User added successfully!");
           }
       }else {
           return new ResultModel(false, "Email and password are required");

       }
   }

}
