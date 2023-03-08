package org.example.maximajavafinal.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Ticket {

    @Id @GeneratedValue
    private long id;

    private String type;

    private int price;

    @ManyToOne (cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Excursion excursion;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Customer customer;

    final Date creationDate = new Date();
    private boolean available = true;

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreationDate() {
        return creationDate;
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


    public Ticket(Excursion excursion, Customer customer) {
        this.type = "booking";
        this.price = 0;
        this.excursion = excursion;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
