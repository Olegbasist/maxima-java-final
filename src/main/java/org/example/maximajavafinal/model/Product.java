package org.example.maximajavafinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private boolean available = true;

    public Product() {
    }
}
