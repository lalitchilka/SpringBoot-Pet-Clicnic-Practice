package com.myapp.springbootpetclinicpractice.repositories;

import com.myapp.springbootpetclinicpractice.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
