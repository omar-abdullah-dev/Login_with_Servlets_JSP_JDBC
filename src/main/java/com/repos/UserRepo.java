package com.repos;

import com.db.DBConnection;
import com.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepo {
    public UserRepo() {
    }
    public User login(String email, String password) {
        User user = null;
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try(
                Connection connection = DBConnection.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ){
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String userEmail = resultSet.getString("email");
//                String userPassword = resultSet.getString("password");
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            }
        }catch (Exception ex){
            System.out.println("An error occurred during login: " + ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }


}
