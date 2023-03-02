package org.example.maximajavafinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;

@Entity
public abstract class AbstractBaseEntity implements Serializable {

    @Id @GeneratedValue
    private long id;

    private String name;

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractBaseEntity() {
    }

    @Override
    public String toString() {
        return getClass() + " {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
