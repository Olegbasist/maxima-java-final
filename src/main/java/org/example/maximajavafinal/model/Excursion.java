package org.example.maximajavafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Excursion {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    private Date date;

    private int capacity;


    @ManyToOne (cascade = CascadeType.MERGE)
    private Guide guide;

    @OneToMany (cascade = CascadeType.MERGE, mappedBy = "excursion", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private List<Ticket> tickets;

    private boolean available = true;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Excursion() {
    }

    public Excursion(String title, Date date, int capacity) {
        this.title = title;
        this.date = date;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", name='" + title + '\'' +
                //", description='" + description + '\'' +
                ", date=" + date +
                ", guide=" + guide +
                ", capacity=" + capacity +
                ", booked tickets=" + tickets.size() +
                '}';
    }
}
