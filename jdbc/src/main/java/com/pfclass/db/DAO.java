package com.pfclass.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Function;

public class DAO<T>{

    protected static final Logger log = LoggerFactory.getLogger(DAO.class);

    public Connection getConnection() throws SQLException {
        //return DriverManager.getConnection("jdbc:mysql://192.168.33.10:3306/petclinic?useSSL=false","root","example");

        return DriverManager.getConnection("jdbc:sqlite:"+DAO.class.getResource("/db/sqlite/petclinic.db").getFile());
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

    protected T persist(String sql, Function<PreparedStatement, T> action){
        try(Connection conn = getConnection()){
            conn.setAutoCommit(Boolean.TRUE);
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                return action.apply(stmt);
            }catch(SQLException e){
                log.error("Error creating statement ", e);
            }
        }catch(SQLException e){
            log.error("Error opening connection ", e);
        }
        return null;
    }

}
