package com.pfclass.db;

import com.pfclass.model.VetModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VetDAOFullTest {

    VetDAOFull dao = new VetDAOFull();
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