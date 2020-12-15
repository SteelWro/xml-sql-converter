package me.cwiklinski.service;

import me.cwiklinski.configuration.DAOConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgreSQLConnect {

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DAOConfiguration.URL, DAOConfiguration.USER, DAOConfiguration.PASSWORD);
        return conn;
    }
}
