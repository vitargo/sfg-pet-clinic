package org.vitargo.vspetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

import javax.persistence.*;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Builder
    public Visit(Long id, LocalDate date, String description, Pet pet) {
        super(id);
        log.info("Visit Constructor");
        this.date = date;
        this.description = description;
        this.pet = pet;
    }
}
