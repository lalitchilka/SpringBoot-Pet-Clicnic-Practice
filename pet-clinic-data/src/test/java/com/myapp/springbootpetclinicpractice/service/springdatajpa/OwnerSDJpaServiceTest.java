package com.myapp.springbootpetclinicpractice.service.springdatajpa;

import com.myapp.springbootpetclinicpractice.model.Owner;
import com.myapp.springbootpetclinicpractice.repositories.OwnerRepository;
import com.myapp.springbootpetclinicpractice.repositories.PetRepository;
import com.myapp.springbootpetclinicpractice.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Chilka";

    Owner returnOwner;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner chilka = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, chilka.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> allOwners = new HashSet<>();
        allOwners.add(Owner.builder().id(1L).build());
        allOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(allOwners);

        assertEquals(2, ownerSDJpaService.findAll().size());

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);

        assertEquals(1L, owner.getId());

        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findByIdNotFound(){
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findById(1L);

        assertNull(owner);

        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}