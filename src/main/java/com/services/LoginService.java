package com.services;

import com.models.ResultModel;
import com.repos.UserRepo;


public class LoginService {
    private final UserRepo userRepo=new UserRepo();

   public ResultModel login(String email, String password){
       if (email == null || email.trim().isEmpty()
               || password == null || password.trim().isEmpty()){
           return new ResultModel(false, "Email and password are required ");
       }
       boolean exist = userRepo.login(email, password)!=null;
       if (!exist){
           return new ResultModel(false,"Invalid email or password");
       }
       return new ResultModel(true,"Login Successful");
   }
}
