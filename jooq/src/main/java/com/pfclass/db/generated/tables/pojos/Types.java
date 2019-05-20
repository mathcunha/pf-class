/*
 * This file is generated by jOOQ.
 */
package com.pfclass.db.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "types", schema = "petclinic", indexes = {
    @Index(name = "name", columnList = "name ASC"),
    @Index(name = "PRIMARY", unique = true, columnList = "id ASC")
})
public class Types implements Serializable {

    private static final long serialVersionUID = -991357666;

    private Integer id;
    private String  name;

    public Types() {}

    public Types(Types value) {
        this.id = value.id;
        this.name = value.name;
    }

    public Types(
        Integer id,
        String  name
    ) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 10)
    @NotNull
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 80)
    @Size(max = 80)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Types (");

        sb.append(id);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}
