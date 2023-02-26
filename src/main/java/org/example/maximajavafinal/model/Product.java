package org.example.maximajavafinal.model;

import jakarta.persistence.*;

@Entity
@Inheritance
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @ManyToOne (cascade = CascadeType.REFRESH)
    private Guide guide;

    private boolean available = true;

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
