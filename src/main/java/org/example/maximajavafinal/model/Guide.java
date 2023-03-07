package org.example.maximajavafinal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Guide {

    @Id @GeneratedValue
    private long id;

    private String name;


    @OneToMany (mappedBy = "guide", fetch = FetchType.EAGER)
    private List<Excursion> excursions;

    private boolean available = true;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(List<Excursion> excursions) {
        this.excursions = excursions;
    }

    public Guide(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Guide() {
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
