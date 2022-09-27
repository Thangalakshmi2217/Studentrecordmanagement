package com.atmo.database.connection;

import com.atmo.database.exception.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Map;

/**
 * <p>
 * Connects to the database and provides DB related services.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class DatabaseConnection {

    private static Map<String, String> property;

    /**
     * <p>
     * Gets the {@link Connection} through driver manager and connects the database using the localhost path,
     * username and password provided and returns the connection.
     * </p>
     *
     * @return {@link Connection} to the database
     */
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(property.get("karaf.jdbc.url"), property.get("karaf.jdbc.username"), property.get("karaf.jdbc.password"));

            return connection;
        } catch (Exception exception) {
            throw new ConnectionFailedException("Connection Failed");
        }
    }

    /**
     * <p>
     * Properties which holds the necessary information for the database connection.
     * </p>
     *
     * @param properties which contains the connection attributes which connects the database
     */
    public static void setDataBaseProperty(Map<String, String> properties) {
        property = properties;
    }
}