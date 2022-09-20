package com.logic.util;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
// We're going to make a Singleton Connection class
public class ConnectionUtil {

    // Private static instance
    private static Connection conn = null;

    private ConnectionUtil() {
    }
    public static Connection getConnection() {

        try {
            if (conn != null && !conn.isClosed()) {
                return conn;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        String url;
        String username;
        String password;

        Properties prop = new Properties();

        try {

            prop.load(new FileReader("C:\\Users\\yourName\\src\\main\\resources\\application.properties"));

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            try {
                conn = DriverManager.getConnection(url, username, password);
//                System.out.println("Established Connection to Database!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Cannot establish connection");
                e.printStackTrace();
            }
            return conn;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
