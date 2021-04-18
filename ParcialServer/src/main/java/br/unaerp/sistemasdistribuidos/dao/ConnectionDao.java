package br.unaerp.sistemasdistribuidos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
    private static Connection connection = null;

    public static void connect() throws ClassNotFoundException, SQLException {
            final String host = "localhost";
            final String database = "parcial";
            final String URL = "jdbc:mysql://" + host + "/" + database + "?autoReconnect=true";
            final String driver = "com.mysql.jdbc.Driver";
            final String user = "dev";
            final String password = "admin";
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, user, password);
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }
}
