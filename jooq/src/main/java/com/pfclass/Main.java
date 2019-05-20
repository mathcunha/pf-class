package com.pfclass;

import com.pfclass.db.ConnectionFactory;
import com.pfclass.db.generated.tables.Vets;
import com.pfclass.db.generated.tables.daos.VetsDao;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.types.UInteger;

import java.io.IOException;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally

            DSLContext create = DSL.using(ConnectionFactory.getDS(), SQLDialect.MYSQL);
            Result<Record> result = create.select().from(Vets.VETS).fetch();

            for (Record r : result) {
                Integer id = r.getValue(Vets.VETS.ID);
                String firstName = r.getValue(Vets.VETS.FIRST_NAME);
                String lastName = r.getValue(Vets.VETS.LAST_NAME);

                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }

        Configuration configuration = new DefaultConfiguration().set(ConnectionFactory.getDS()).set(SQLDialect.MYSQL);
        // Initialise the DAO with the Configuration
        VetsDao dao = new VetsDao(configuration);
        System.out.println(dao.fetchById(12));

    }
}
