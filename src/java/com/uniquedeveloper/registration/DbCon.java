package com.uniquedeveloper.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(1)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/esupermarket", "root", "1234567");
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
