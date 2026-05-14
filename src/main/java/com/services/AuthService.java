package com.services;

import com.repos.UserRepo;


public class AuthService {
    private final UserRepo loginRepo=new UserRepo();

    public AuthService() {
    }
    public boolean Login( String email, String password) {
        return loginRepo.login(email,password) != null;
    }
}
