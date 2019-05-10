package com.pfclass.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.function.Function;

public class DAO<T>{

    protected static final Logger log = LoggerFactory.getLogger(DAO.class);

    protected Connection getConnection() throws SQLException {
        return ConnectionFactory.getConnection();
    }

    protected Connection getPooledConnection() throws IOException, SQLException {
        return ConnectionFactory.getPooledConnection();
    }

    protected T persist(String sql, Function<PreparedStatement, T> action){
        try(var conn = getConnection()){
            conn.setAutoCommit(Boolean.TRUE);
            try(var stmt = conn.prepareStatement(sql)){
                return action.apply(stmt);
            }catch(SQLException e){
                log.error("Error creating statement ", e);
            }
        }catch(SQLException e){
            log.error("Error opening connection ", e);
        }
        return null;
    }

    protected List<T> find(String sql, Function<ResultSet, List<T>> action){
        try(var conn = getConnection()){
            conn.setAutoCommit(Boolean.TRUE);
            try(var stmt = conn.prepareStatement(sql)){
                try(var rs = stmt.executeQuery()) {
                    return action.apply(rs);
                }
                catch(SQLException e){
                    log.error("Error finding ", e);
                }
            }catch(SQLException e){
                log.error("Error creating statement ", e);
            }
        }catch(SQLException e){
            log.error("Error opening connection ", e);
        }
        return null;
    }

    protected void delete(String tableName, Long id)  {
        try(var conn = getConnection()){
            conn.setAutoCommit(Boolean.TRUE);
            try(var stmt = conn.createStatement()){
                stmt.execute(String.format("delete from %s where id = %d", tableName, id));
            }catch(SQLException e){
                log.error(String.format("Error deleting table %s with %d", tableName, id), e);
            }
        }catch(SQLException e){
            log.error("Error opening connection ", e);
        }
    }

    protected T findById(String tableName, Long id, Function<ResultSet, T> action){
        try(var conn = getConnection()){
            conn.setAutoCommit(Boolean.TRUE);
            try(var stmt = conn.createStatement()){
                try(var rs = stmt.executeQuery(String.format("select * from %s where id = %d", tableName, id))){
                    return action.apply(rs);
                }
            }catch(SQLException e){
                log.error(String.format("Error reading table %s with %d", tableName, id), e);
            }
        }catch(SQLException e){
            log.error("Error opening connection ", e);
        }
        return null;
    }

}
