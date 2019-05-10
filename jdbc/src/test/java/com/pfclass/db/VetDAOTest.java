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
    void insert()  {
        dao.insert(v);
    }

    @Test
    void getById()  {
        assertEquals(v , dao.findById(v.getId()));
    }

    @Test
    void update(){
        v.setFirstName("Dr. "+v.getFirstName());
        assertEquals(v , dao.update(v));
    }

    @Test
    void delete(){
        assertEquals(v , dao.delete(v.getId()));
    }
}