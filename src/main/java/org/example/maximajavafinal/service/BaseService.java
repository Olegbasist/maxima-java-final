package org.example.maximajavafinal.service;

import jakarta.persistence.Inheritance;
import org.example.maximajavafinal.exeptions.NotFoundException;
import org.example.maximajavafinal.model.AbstractBaseEntity;
import org.example.maximajavafinal.repository.AbstractBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Inheritance
public abstract class BaseService <T extends AbstractBaseEntity, ID extends Serializable> implements AbstractBaseService <T, ID> {

    @Autowired
    private AbstractBaseRepository <T, ID> abstractBaseRepository;

    @Override
    public T save(T entity) {
        return abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public T findById(ID id) {
        return abstractBaseRepository.findById(id).orElseThrow(() ->new NotFoundException("id=" + id));
    }
    /*public Optional<T> findByIdWithOptional(ID id) {
        return abstractBaseRepository.findById(id); // Optional умеет возвращать если объект null
    }*/

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public T updateById(T entity, ID entityId) {return null;
    }

    @Override
    public void delete(T entity) { abstractBaseRepository.delete(entity);

    }

    @Override
    public void deleteById(ID id) {
        if (findById(id) != null) {
            abstractBaseRepository.deleteById(id);
        } else System.out.println("No such id=" +id +". Nothing deleted!");
    }
}
