package com.bank;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Loading JDBC driver ....");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/portfolio_db?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
        String username = "root";
        String password = "jasam4242";
        String query = "select * from education";
        Connection connection = null;
        Statement stmt = null;


        try {
            System.out.println("Connecting to SQL db");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the DB!");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(" ");
                System.out.println(rs.getString(2));
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Closing the connection");
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }

            };
        }

    }
}

