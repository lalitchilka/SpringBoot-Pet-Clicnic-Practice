package com.myapp.springbootpetclinicpractice.service;

import com.myapp.springbootpetclinicpractice.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
