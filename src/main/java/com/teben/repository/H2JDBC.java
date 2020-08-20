package com.teben.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class H2JDBC {
    private static InputStream inputStream;
    private static Connection connection;
    public static Connection connectH2() {
        try {
            Properties properties = new Properties();
            String propFileName = "H2JDBC.properties";

            inputStream = H2JDBC.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }

            String driver = properties.getProperty("h2.driver");
            String url = properties.getProperty("h2.url");
            String user = properties.getProperty("h2.user");
            String password = properties.getProperty("h2.password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       return connection;
    }
}
