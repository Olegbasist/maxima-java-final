package org.example.maximajavafinal.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id @GeneratedValue
    private long id;

    private int price;

    @ManyToOne (cascade = CascadeType.REMOVE)
    private Excursion excursion;

    private boolean available = true;

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Ticket(int price) {
        this.price = price;
    }

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
