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

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Olena");
        owner1.setLastName("DogLover");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mykola");
        owner2.setLastName("CatLover");

        ownerService.save(owner2);

        System.out.println("Loading owner...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sofiia");
        vet1.setLastName("SmallPetVet");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vitaliy");
        vet2.setLastName("BigPetVet");

        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
