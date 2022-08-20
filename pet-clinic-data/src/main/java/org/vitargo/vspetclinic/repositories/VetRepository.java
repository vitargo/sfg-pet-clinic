package org.vitargo.vspetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.vitargo.vspetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
