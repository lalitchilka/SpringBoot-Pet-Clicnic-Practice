package com.myapp.springbootpetclinicpractice.service.map;

import com.myapp.springbootpetclinicpractice.model.Visit;
import com.myapp.springbootpetclinicpractice.service.VisitService;

import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null || object.getPet().getOwner() == null
        || object.getPet().getId() == null || object.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid object");
        }
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
