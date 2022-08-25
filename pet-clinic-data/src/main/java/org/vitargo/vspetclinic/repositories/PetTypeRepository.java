package org.vitargo.vspetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.vitargo.vspetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
