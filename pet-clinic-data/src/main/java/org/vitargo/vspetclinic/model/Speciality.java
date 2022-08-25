package org.vitargo.vspetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        log.info("Speciality Constructor");
        this.description = description;
    }
}
