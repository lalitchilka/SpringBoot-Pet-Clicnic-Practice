package com.myapp.springbootpetclinicpractice.service;

import com.myapp.springbootpetclinicpractice.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
