package com.myapp.springbootpetclinicpractice.service;

import com.myapp.springbootpetclinicpractice.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
