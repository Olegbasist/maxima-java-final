package org.example.maximajavafinal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id @GeneratedValue
    private long id;

    private String name;

    private String contacts;

    @OneToMany (cascade = CascadeType.MERGE, mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Customer(String name, String contacts) {
        this.name = name;
        this.contacts = contacts;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts='" + contacts + '\'' +
                '}';
    }
}
