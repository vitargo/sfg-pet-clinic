package org.vitargo.vspetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.vitargo.vspetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
