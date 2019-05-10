package com.pfclass.db;

import com.pfclass.model.VetModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VetDAOFull {

    protected final Logger log = LoggerFactory.getLogger(VetDAOFull.class);

    public VetModel insert(VetModel vet) {
        //TODO - https://www.journaldev.com/2489/jdbc-statement-vs-preparedstatement-sql-injection-example

        try (Connection conn = ConnectionFactory.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement("insert into vets values (?, ?, ?)")) {
                int i = 1;
                stmt.setLong(i++, vet.getId());
                stmt.setString(i++, vet.getFirstName());
                stmt.setString(i++, vet.getLastName());

                VetModel v = null;
                if (stmt.execute()) {
                    conn.commit();
                    v = vet;
                }

                return v;
            } catch (SQLException e) {
                log.error("PreparedStatement ", e);
                return null;
            }
        } catch (SQLException e) {
            log.error("Error opening connection ", e);
            return null;
        }
    }

    public VetModel findById(Long id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from  vets where id = ?");
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        VetModel v = null;
        if (rs.next()) {
            v = new VetModel(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return v;
    }

    private VetModel loadVet(ResultSet rs) throws SQLException {
        return new VetModel(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
    }

    public List<VetModel> findAll() {
        try (Connection conn = ConnectionFactory.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement("select * from  vets where id = ?")) {

                try (ResultSet rs = stmt.executeQuery()) {

                    List<VetModel> vets = new ArrayList<VetModel>();
                    while (rs.next()) {
                        vets.add(loadVet(rs));
                    }
                    return vets;

                } catch (SQLException e) {
                    log.error("Error reading vets ", e);
                    return null;
                }

            } catch (SQLException e) {
                log.error("Error reading vets ", e);
                return null;
            }
        } catch (SQLException e) {
            log.error("Error opening connection ", e);
            return null;
        }
    }

    public VetModel update(VetModel vet) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
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
        conn.close();
        return v;
    }

    public VetModel delete(Long id) throws SQLException, IOException {
        Connection conn = ConnectionFactory.getPooledConnection();
        VetModel v = findById(id);

        if (v != null) {
            PreparedStatement stmt = conn.prepareStatement("delete from vets where id = ?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        }

        conn.close();
        return v;
    }
}
