package com.myapp.springbootpetclinicpractice.bootstrap;

import com.myapp.springbootpetclinicpractice.model.Owner;
import com.myapp.springbootpetclinicpractice.model.Vet;
import com.myapp.springbootpetclinicpractice.service.OwnerService;
import com.myapp.springbootpetclinicpractice.service.VetService;
import com.myapp.springbootpetclinicpractice.service.map.OwnerServiceMap;
import com.myapp.springbootpetclinicpractice.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Lalit");
        owner1.setLastName("Chilka");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Asu");
        owner2.setLastName("Bieganowska");

        ownerService.save(owner2);

        System.out.println("***************Owners Loaded***************");

        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("John");
        v1.setLastName("Snow");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("Terion");
        v2.setLastName("Lanister");

        vetService.save(v2);

        System.out.println("***************Vet Loaded***************");
    }
}
