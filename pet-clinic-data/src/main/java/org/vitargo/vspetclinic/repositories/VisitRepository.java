package org.vitargo.vspetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.vitargo.vspetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
