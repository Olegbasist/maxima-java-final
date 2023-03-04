package org.example.maximajavafinal.service;

import jakarta.persistence.Inheritance;
import org.example.maximajavafinal.exeptions.NotFoundException;
import org.example.maximajavafinal.model.AbstractEntity;
import org.example.maximajavafinal.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Inheritance
public abstract class SimpleService<T extends AbstractEntity, ID extends Serializable> implements AbstractService<T, ID> {

    @Autowired
    private AbstractRepository<T, ID> abstractRepository;

    //Create
    @Override
    public void save(T entity) {
        abstractRepository.save(entity);
    }

    //Read
    @Override
    public List<T> findAll() {
        return abstractRepository.findAll();
    }

    @Override
    public T findById(ID id) {
        return abstractRepository.findById(id).orElseThrow(() ->new NotFoundException("id=" + id));
    }
    /*public Optional<T> findByIdWithOptional(ID id) {
        return abstractBaseRepository.findById(id); // Optional умеет возвращать если объект null
    }*/

    //Update пока не понял зачем
    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public T updateById(T entity, ID entityId) {return null;
    }

    //Delete
    @Override
    public void delete(T entity) { abstractRepository.delete(entity);

    }

    @Override
    public void deleteById(ID id) {
        if (findById(id) != null) {
            abstractRepository.deleteById(id);
        } else System.out.println("No such id=" +id +". Nothing deleted!");
    }

    @Override
    public void deleteAll(){
        abstractRepository.deleteAll();
    }
}
