package com.pfclass.db;

import com.pfclass.model.VetModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VetDAO extends DAO<VetModel> {
    public VetModel insert(VetModel vet) {
        return persist("insert into " + VetModel.getTableName() + " values (?, ?, ?)",
                (PreparedStatement stmt) -> {
                    int i = 1;
                    try {
                        stmt.setLong(i++, vet.getId());
                        stmt.setString(i++, vet.getFirstName());
                        stmt.setString(i++, vet.getLastName());
                        VetModel v = null;
                        if (stmt.execute()) {
                            v = vet;
                        }
                        return v;
                    } catch (SQLException e) {
                        log.error("error inserting vetmodel", e);
                    }
                    return null;
                });
    }

    private VetModel loadVet(ResultSet rs) throws SQLException {
        return new VetModel(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
    }

    public VetModel findById(Long id) {
        return findById(VetModel.getTableName(), id,
                (ResultSet rs) -> {
                    VetModel v = null;
                    try {
                        if (rs.next()) {
                            v = loadVet(rs);
                        }
                    } catch (SQLException e) {
                        log.error("error reading vetmodel", e);
                    }
                    return v;
                });
    }

    public List<VetModel> findAll() {
        return find("select * from " + VetModel.getTableName(), (ResultSet rs) -> {
            try {
                List<VetModel> vets = new ArrayList<VetModel>();
                while (rs.next()) {
                    vets.add(loadVet(rs));
                }
                return vets;
            } catch (SQLException e) {
                log.error("Error  ", e);
            }
            return null;
        });
    }

    public VetModel update(VetModel vet) {
        return persist("update " + VetModel.getTableName() + " set first_name = ?, last_name = ? where id = ?",
                (PreparedStatement stmt) -> {
                    int i = 1;
                    try {
                        stmt.setString(i++, vet.getFirstName());
                        stmt.setString(i++, vet.getLastName());
                        stmt.setLong(i++, vet.getId());
                        VetModel v = null;
                        if (stmt.executeUpdate() > 0) {
                            v = vet;
                        }

                        return v;
                    } catch (SQLException e) {
                        log.error("error updating vetmodel", e);
                    }
                    return null;
                });
    }

    public VetModel delete(Long id) {
        var vet = findById(id);
        delete(VetModel.getTableName(), id);
        return vet;
    }
}
