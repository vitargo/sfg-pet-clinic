package org.vitargo.vspetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.vitargo.vspetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner getOwnerByFirstName(String firstName);
}
