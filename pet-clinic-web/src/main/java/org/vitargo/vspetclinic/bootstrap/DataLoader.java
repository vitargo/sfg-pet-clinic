package org.vitargo.vspetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.vitargo.vspetclinic.model.*;
import org.vitargo.vspetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dogType = new PetType();
        dogType.setName("Dog");
        PetType savedDogType = petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("Cat");
        PetType savedCatType = petTypeService.save(catType);

        System.out.println("Loading pet types...");

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("radiology");
        Speciality radiology = specialitiesService.save(speciality1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("dentistry");
        Speciality dentistry = specialitiesService.save(speciality2);

        Speciality speciality3 = new Speciality();
        speciality3.setDescription("surgery");
        Speciality surgery = specialitiesService.save(speciality3);

        System.out.println("Loading specialities...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Nina");
        owner1.setLastName("DogOwner");
        owner1.setAddress("Khreschatyk str.");
        owner1.setCity("Kyiv");
        owner1.setTelephone("+380111111111");

        Pet petOwner1 = new Pet();
        petOwner1.setName("Murka");
        petOwner1.setBirthday(LocalDate.of(2011, 4,5));
        petOwner1.setPetType(savedCatType);
        petOwner1.setOwner(owner1);

        owner1.getPets().add(petOwner1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mykola");
        owner2.setLastName("CatOwner");
        owner2.setAddress("Maydan Nezalezhnosti sqr.");
        owner2.setCity("Kyiv");
        owner2.setTelephone("+380222222222");

        Pet petOwner2 = new Pet();
        petOwner2.setName("Zhuchka");
        petOwner2.setBirthday(LocalDate.of(2016, 12,15));
        petOwner2.setPetType(savedDogType);
        petOwner2.setOwner(owner2);

        owner1.getPets().add(petOwner2);
        ownerService.save(owner2);

        System.out.println("Loading owner...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sofiia");
        vet1.setLastName("SmallPetVet");
        vet1.getSpecialities().add(dentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vitaliy");
        vet2.setLastName("BigPetVet");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Loading vets...");

        Visit catVisit = new Visit();
        catVisit.setPet(petOwner1);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneeze cat!");

        visitService.save(catVisit);

        System.out.println("Loading visits...");
    }
}
