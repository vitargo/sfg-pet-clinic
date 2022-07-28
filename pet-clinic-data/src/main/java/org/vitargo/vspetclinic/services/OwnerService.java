package org.vitargo.vspetclinic.services;

import org.vitargo.vspetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
