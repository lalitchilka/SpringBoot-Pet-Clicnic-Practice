package com.myapp.springbootpetclinicpractice.bootstrap;

import com.myapp.springbootpetclinicpractice.model.Owner;
import com.myapp.springbootpetclinicpractice.model.Pet;
import com.myapp.springbootpetclinicpractice.model.PetType;
import com.myapp.springbootpetclinicpractice.model.Vet;
import com.myapp.springbootpetclinicpractice.service.OwnerService;
import com.myapp.springbootpetclinicpractice.service.PetTypeService;
import com.myapp.springbootpetclinicpractice.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

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
        owner1.getPets().add(asusPet);

        ownerService.save(owner2);

        System.out.println("***************Owners Loaded***************");

        Vet v1 = new Vet();
        v1.setFirstName("John");
        v1.setLastName("Snow");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Terion");
        v2.setLastName("Lanister");

        vetService.save(v2);

        Vet v3 = new Vet();
        v3.setFirstName("Cerse");
        v3.setLastName("Lanister");

        vetService.save(v3);

        System.out.println("***************Vet Loaded***************");
    }
}
