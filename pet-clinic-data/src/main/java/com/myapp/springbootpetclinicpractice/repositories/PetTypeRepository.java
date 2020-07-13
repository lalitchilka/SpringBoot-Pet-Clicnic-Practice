package com.myapp.springbootpetclinicpractice.repositories;

import com.myapp.springbootpetclinicpractice.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
