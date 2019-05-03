package com.pfclass.db;

import com.pfclass.model.VetModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VetDAO extends DAO {
    public VetModel insert(VetModel vet) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into vets values (?, ?, ?)");
        int i = 1;
        stmt.setLong(i++, vet.getId());
        stmt.setString(i++, vet.getFirstName());
        stmt.setString(i++, vet.getLastName());

        VetModel v = null;
        if (stmt.execute()) {
            conn.commit();
            v = vet;
        }

        stmt.close();

        closeConnection(conn);
        return v;
    }

    public VetModel update(VetModel vet) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("update vets set first_name = ?, last_name = ? where id = ?");
        int i = 1;
        stmt.setString(i++, vet.getFirstName());
        stmt.setString(i++, vet.getLastName());
        stmt.setLong(i++, vet.getId());
        VetModel v = null;
        if (stmt.executeUpdate() > 0) {
            v = vet;
        }
        stmt.close();
        closeConnection(conn);
        return v;
    }

    public VetModel getById(Long id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from  vets where id = ?");
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        VetModel v = null;
        if(rs.next()){
            v = new VetModel(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
        }
        rs.close();
        stmt.close();
        closeConnection(conn);
        return v;
    }

    public VetModel delete(Long id) throws SQLException, IOException {
        Connection conn = getPooledConnection();
        VetModel v = getById(id);

        if(v != null){
            PreparedStatement stmt = conn.prepareStatement("delete from vets where id = ?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        }

        closeConnection(conn);
        return v;
    }
}
