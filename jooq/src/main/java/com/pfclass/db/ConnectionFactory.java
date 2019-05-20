package com.pfclass.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static HikariDataSource ds;

    public static HikariDataSource getDS() throws IOException {
        if (ds == null) {
            Properties props = new Properties();
            props.load(ConnectionFactory.class.getResourceAsStream("/db/hikari.properties"));
            HikariConfig config = new HikariConfig(props);
            ds = new HikariDataSource(config);
        }
        return ds;
    }

    public static Connection getConnection() throws SQLException, IOException {
        return getDS().getConnection();
    }
}
