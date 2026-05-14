package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String url = "jdbc:postgresql://localhost:5432/LoginServletDB";
    private final static String username = "postgres";
    private final static String password = "Moharam@2002";
    private Connection dbConnection;

    private DBConnection() {
      dbConnection=  getConnection();
    }
    private static DBConnection db;
    public static DBConnection getInstance(){
        synchronized (DBConnection.class){
            if (db == null) {
                db = new DBConnection();
            }
        }
        return db;
    }

     public Connection getConnection( ) {

        try  {
            Class.forName("org.postgresql.Driver");
            if (dbConnection != null && !dbConnection.isClosed()) {
                System.out.println("Using existing database connection.");
                return dbConnection;
            }
            dbConnection= DriverManager.getConnection(url,username,password);
            if(dbConnection != null){
                System.out.println("Connected to the database successfully!");
                return dbConnection;
            }else{
                System.out.println("Failed to connect to the database.");
                return null;
            }
        }catch(SQLException ex){
            System.out.println("An error occurred while connecting to the database: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
     }
}
