package com.myapp.springbootpetclinicpractice.bootstrap;

import com.myapp.springbootpetclinicpractice.model.*;
import com.myapp.springbootpetclinicpractice.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
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
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Lalit");
        owner1.setLastName("Chilka");
        owner1.setAddress("1142, Sykes Extension");
        owner1.setCity("Kolhapur");
        owner1.setTelephone("8452035525");

        Pet lalitsPet = new Pet();
        lalitsPet.setPetType(savedCatType);
        lalitsPet.setName("Catush");
        lalitsPet.setBirthDate(LocalDate.now());
        lalitsPet.setOwner(owner1);
        owner1.getPets().add(lalitsPet);

        ownerService.save(owner1);

        Visit catVisit = new Visit();
        catVisit.setPet(lalitsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Smelly cat");

        visitService.save(catVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Asu");
        owner2.setLastName("Bieganowska");
        owner2.setAddress("23, Migowska");
        owner2.setCity("Gdansk");
        owner2.setTelephone("515566664");

        Pet asusPet = new Pet();
        asusPet.setPetType(savedDogType);
        asusPet.setName("Fluffek");
        asusPet.setBirthDate(LocalDate.now());
        asusPet.setOwner(owner2);
        owner2.getPets().add(asusPet);

        ownerService.save(owner2);

        System.out.println("***************Owners Loaded***************");

        Vet v1 = new Vet();
        v1.setFirstName("John");
        v1.setLastName("Snow");
        v1.getSpecialities().add(radiology);

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Terion");
        v2.setLastName("Lanister");
        v2.getSpecialities().add(surgery);

        vetService.save(v2);

        Vet v3 = new Vet();
        v3.setFirstName("Cerse");
        v3.setLastName("Lanister");

        vetService.save(v3);

        System.out.println("***************Vet Loaded***************");
    }
}
