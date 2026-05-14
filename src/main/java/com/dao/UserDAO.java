package com.dao;

import com.db.DBConnection;
import com.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
//TODO: insert new user
//TODO: select all users
//TODO: select user by email
//TODO: select user by id
//TODO: delete user by id
//TODO: update user info by id
//TODO: update user password by id

public class UserDAO {
   private final static String INSERT_USER="insert into users(email,password) values(?,?);";
   private final static String SELECT_ALL_USER="select * from users";
   private final static String SELECT_USER_BY_EMAIL="select * from users where email=?";
   private final static String SELECT_USER_BY_ID="select * from users where id=?";
   private final static String DELETE_USER="delete from users where id=?";
    private final static String UPDATE_USER_INFO="update users set email=?,password=? where id=?";
//   private final static String UPDATE_USER="update users set password=? where id=?";

     public UserDAO() {
     }
// DONE:Insert new user
     public boolean insertUser(User user) {
         try(
                 Connection dbConnection= DBConnection.getInstance().getConnection();
                 PreparedStatement ps=dbConnection.prepareStatement(INSERT_USER);
         ){
             ps.setString(1,user.getEmail());
             ps.setString(2,user.getPassword());
             ps.executeQuery();
             ps.getResultSet().next();
             return true;
         }catch (Exception ex){
             System.out.println("An error occurred during inserting user: " + ex.getMessage());
             ex.printStackTrace();
         }
         return false;
     }
//     DONE:get all users
    public List<User> getAllUsers(){
         List<User> users=new ArrayList<>();
         try(
                 Connection dbConnection= DBConnection.getInstance().getConnection();
                 PreparedStatement ps=dbConnection.prepareStatement(SELECT_ALL_USER);
         ){
             ps.executeQuery();
             while (ps.getResultSet().next()) {
                 users.add(
                         new User(ps.getResultSet().getInt("id"),
                                 ps.getResultSet().getString("email"),
                                 ps.getResultSet().getString("password"))
                 );
             }
         }catch(Exception ex){
             System.out.println("An error occurred during getting all users: " + ex.getMessage());
              ex.printStackTrace();
              return users;
         }
         return users;
    }
//   DONE:get user by email
    public User getUserByEmail(String email){
         User user=null;
         try(
                 Connection dbConnection= DBConnection.getInstance().getConnection();
                 PreparedStatement ps=dbConnection.prepareStatement(SELECT_USER_BY_EMAIL);
                 ){
             ps.setString(1,email);
             ps.executeQuery();
             ps.getResultSet().next();
             if (ps.getResultSet().next()) {
                    user = new User(ps.getResultSet().getInt("id"),
                            ps.getResultSet().getString("email"),
                            ps.getResultSet().getString("password"));
             }else {
                 System.out.println("No user found with email: " + email);
             }
         } catch (Exception e) {
                System.out.println("An error occurred during getting user by email: " + e.getMessage());
                e.printStackTrace();
         }
         return user;
    }
//    DONE: get user by ID
    public User getUserById(int id){
         User user=null;
         try(
                 Connection dbConnection= DBConnection.getInstance().getConnection();
                 PreparedStatement ps=dbConnection.prepareStatement(SELECT_USER_BY_ID);
         ){
                ps.setInt(1,id);
                ps.executeQuery();
                if (ps.getResultSet().next()) {
                    user = new User(ps.getResultSet().getInt("id"),
                            ps.getResultSet().getString("email"),
                            ps.getResultSet().getString("password"));
                }else {
                    System.out.println("No user found with id: " + id);
                }
         }catch(Exception ex){
             System.out.println("An error occurred during getting user by id: " + ex.getMessage());
             ex.printStackTrace();
             return user;
         }
         return user;
    }
//    DONE: delete user by id
    public boolean deleteUserById(int id){
         boolean deleted=false;
         try(
                 Connection dbConnection= DBConnection.getInstance().getConnection();
                 PreparedStatement ps=dbConnection.prepareStatement(DELETE_USER);
                 ){
             ps.setInt(1,id);
             deleted=ps.executeUpdate()>0;
             if(deleted){
                 System.out.println("User with id " + id + " deleted successfully.");
             }else {
                 System.out.println("No user found with id: " + id);
             }
         } catch (Exception e) {
                System.out.println("An error occurred during deleting user by id: " + e.getMessage());
                e.printStackTrace();
                return deleted;
         }
         return deleted;
    }
// DONE: update user info
    public boolean updateUserInfo(User user){
         boolean updated=false;
         try(
                 Connection dbConnection= DBConnection.getInstance().getConnection();
                 PreparedStatement ps=dbConnection.prepareStatement(UPDATE_USER_INFO);
                 ){
             ps.setString(1,user.getEmail());
             ps.setString(2,user.getPassword());
             ps.setInt(3,user.getId());
             updated=ps.executeUpdate()>0;
             if(updated){
                 System.out.println("User with email " + user.getEmail() + " updated successfully.");
             }
             else {
                 System.out.println("No user found with email: " + user.getEmail());
             }
         }
         catch (Exception e) {
                System.out.println("An error occurred during updating user info by id: " + e.getMessage());
                e.printStackTrace();
                return updated;
         }
         return updated;
    }


}
