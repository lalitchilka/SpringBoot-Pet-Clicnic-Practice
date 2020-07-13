package com.myapp.springbootpetclinicpractice.repositories;

import com.myapp.springbootpetclinicpractice.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
