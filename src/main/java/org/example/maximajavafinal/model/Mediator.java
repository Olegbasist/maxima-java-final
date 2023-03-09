package org.example.maximajavafinal.model;

public class Mediator {
    long guide_id;
    long excursion_id;
    long customer_id;
    long ticket_id;


    public long getExcursion_id() {
        return excursion_id;
    }

    public void setExcursion_id(long excursion_id) {
        this.excursion_id = excursion_id;
    }

    public long getGuide_id() {
        return guide_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setGuide_id(long guide_id) {
        this.guide_id = guide_id;
    }


    public Mediator() {
    }
}
