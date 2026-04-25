package com.uniajc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 

public class ConexionPostgresDatabase {

    private static String url;
    private static String user;
    private static String password;
    private static boolean configLoaded = false;

    private static void loadConfig() {
        if (configLoaded) return;
        Properties properties = new Properties();
        try (InputStream is = ConexionPostgresDatabase.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is == null) {
                System.err.println("ERROR: No se encontro config.properties en el classpath.");
                System.err.println("  Asegurate de que exista en src/main/resources/config.properties");
                return;
            }
            properties.load(is);
            url      = properties.getProperty("db.url");
            user     = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

            if (url == null || user == null || password == null) {
                System.err.println("ERROR: config.properties no contiene db.url, db.user o db.password.");
                return;
            }
            configLoaded = true;
        } catch (IOException e) {
            System.err.println("ERROR al leer config.properties: " + e.getMessage());
            e.printStackTrace();
        }
    }

   
    public static Connection getConnection() {
        loadConfig();
        if (!configLoaded) return null;
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            System.err.println("ERROR al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
