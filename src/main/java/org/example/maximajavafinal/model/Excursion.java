package org.example.maximajavafinal.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Excursion {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private Date date;

    @ManyToOne
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Excursion() {
    }

    public Excursion(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", guide=" + guide +
                '}';
    }
}
