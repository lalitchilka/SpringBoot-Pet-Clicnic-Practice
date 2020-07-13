package com.myapp.springbootpetclinicpractice.repositories;

import com.myapp.springbootpetclinicpractice.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
