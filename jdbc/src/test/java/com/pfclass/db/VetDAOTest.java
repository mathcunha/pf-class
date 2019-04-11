package com.pfclass.db;

import com.pfclass.model.VetModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class VetDAOTest {

    VetDAO dao = new VetDAO();
    VetModel v = new VetModel(1l, "Susan", " Kelleher");

    @Test
    void insert() throws SQLException {
        dao.insert(v);
    }

    @Test
    void getById() throws SQLException, InterruptedException {
        assertEquals(v , dao.getById(v.getId()));
    }

    @Test
    void update() throws SQLException {
        v.setFirstName("Dr. "+v.getFirstName());
        assertEquals(v , dao.update(v));
    }

    @Test
    void delete() throws SQLException, IOException {
        assertEquals(v , dao.delete(v.getId()));
    }
}