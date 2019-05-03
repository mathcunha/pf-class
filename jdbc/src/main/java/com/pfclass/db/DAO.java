package com.pfclass.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private static final Logger log = LoggerFactory.getLogger(DAO.class);

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://192.168.33.10:3306/petclinic?useSSL=false","root","example");
    }

    public Connection getPooledConnection() throws IOException, SQLException {
        return ConnectionFactory.getConnection();
    }

    public void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            log.error("error closing connection", e);
        }
    }
}
