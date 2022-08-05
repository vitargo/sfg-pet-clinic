package org.vitargo.vspetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.vitargo.vspetclinic.model.Owner;
import org.vitargo.vspetclinic.model.Vet;
import org.vitargo.vspetclinic.services.OwnerService;
import org.vitargo.vspetclinic.services.VetService;
import org.vitargo.vspetclinic.services.map.OwnerServiceMap;
import org.vitargo.vspetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Nina");
        owner1.setLastName("DogOwner");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mykola");
        owner2.setLastName("CatOwner");

        ownerService.save(owner2);

        System.out.println("Loading owner...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sofiia");
        vet1.setLastName("SmallPetVet");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vitaliy");
        vet2.setLastName("BigPetVet");

        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
