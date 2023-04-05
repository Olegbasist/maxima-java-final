package org.example.maximajavafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE guide SET available = false WHERE id=?")
@Where(clause = "available=true")
public class Guide {

    @Id @GeneratedValue
    private long id;

    private String name;


    @OneToMany (mappedBy = "guide", fetch = FetchType.EAGER)
    @JsonIgnore
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


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Guide() {
    }
    public Guide(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
