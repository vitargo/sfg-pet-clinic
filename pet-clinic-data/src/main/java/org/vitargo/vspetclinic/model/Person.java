package org.vitargo.vspetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Builder
    public Person(Long id, String firstName, String lastName) {
        super(id);
        log.info("Person constructor");
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
