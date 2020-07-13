package com.myapp.springbootpetclinicpractice.repositories;

import com.myapp.springbootpetclinicpractice.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetReposiroty extends CrudRepository<Vet, Long> {
}
