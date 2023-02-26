package org.example.maximajavafinal.model;

import jakarta.persistence.Entity;
import java.util.Date;


@Entity
public class Excursion extends Product{
    public Excursion() {
    }

    private Date date;
}
