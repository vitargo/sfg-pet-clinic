package org.vitargo.vspetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private PetType patType;
    private Owner owner;
    private LocalDate birthday;

    public PetType getPatType() {
        return patType;
    }

    public void setPatType(PetType patType) {
        this.patType = patType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
