package org.example.maximajavafinal.model;

public class Assigner {
    long guide_id;
    long excursion_id;


    public long getExcursion_id() {
        return excursion_id;
    }

    public void setExcursion_id(long excursion_id) {
        this.excursion_id = excursion_id;
    }

    public long getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(long guide_id) {
        this.guide_id = guide_id;
    }

    public Assigner(long guide_id, long excursion_id) {
        this.guide_id = guide_id;
        this.excursion_id = excursion_id;
    }

    public Assigner() {
    }
}
