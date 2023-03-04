package org.example.maximajavafinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public abstract class AbstractEntity implements Serializable {

    @Id @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }



    public AbstractEntity() {
    }
}
