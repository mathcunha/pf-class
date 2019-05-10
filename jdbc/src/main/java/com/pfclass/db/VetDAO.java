package com.pfclass.db;

import com.pfclass.model.VetModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VetDAO extends DAO<VetModel> {
    public VetModel insert(VetModel vet) {

        return persist("insert into vets values (?, ?, ?)",
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

    public VetModel findById(Long id) {
        return persist("select * from  vets where id = ?",
                (PreparedStatement stmt) -> {
                    try {
                        stmt.setLong(1, id);
                        ResultSet rs = stmt.executeQuery();
                        VetModel v = null;
                        if (rs.next()) {
                            v = new VetModel(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
                        }
                        return v;
                    } catch (SQLException e) {
                        log.error("error reading vetmodel", e);
                    }
                    return null;
                });
    }


    public VetModel findAll() {
        try (Connection conn = getConnection()) {
            List<VetModel> vets = new ArrayList<>();

            try (PreparedStatement stmt = conn.prepareStatement("select * from  vets where id = ?")) {
                return null;

            } catch (SQLException e) {
                log.error("Error reading vets ", e);
                return null;
            }
        } catch (SQLException e) {
            log.error("Error opening connection ", e);
            return null;
        }
    }

    public VetModel update(VetModel vet) {

        return persist("update vets set first_name = ?, last_name = ? where id = ?",
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

    public VetModel delete(Long id)  {
        try (Connection conn = getConnection()) {
            VetModel v = findById(id);
            if (v != null) {
                try (PreparedStatement stmt = conn.prepareStatement("delete from vets where id = ?")) {
                    stmt.setLong(1, id);
                    stmt.execute();
                } catch (SQLException e) {
                    log.error("Error creating statement ", e);
                }
            }
            return v;

        } catch (SQLException e) {
            log.error("Error opening connection ", e);
        }
        return null;
    }
}
