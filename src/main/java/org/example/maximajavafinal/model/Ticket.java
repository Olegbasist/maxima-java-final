package org.example.maximajavafinal.model;

import jakarta.persistence.*;

@Entity
public class Ticket extends AbstractEntity {


    private int price;

    @ManyToOne (cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Excursion excursion;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Customer customer;

    private boolean available = true;

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
        this.price = 0;
        this.excursion = excursion;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + getId() +
                ", price=" + price +
                //", excursion=" + excursion.getId() + excursion.getName() +
                '}';
    }
}
