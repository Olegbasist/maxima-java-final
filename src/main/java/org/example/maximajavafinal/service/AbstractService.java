package org.example.maximajavafinal.service;

import org.example.maximajavafinal.model.AbstractEntity;

import java.io.Serializable;
import java.util.List;

public interface AbstractService<T extends AbstractEntity, ID extends Serializable>{

    public abstract void save(T entity);
    public abstract List<T> findAll();
    public abstract T findById(ID entityId);

    public abstract T update(T entity);
    public abstract T updateById(T entity, ID entityId);
    public abstract void delete(T entity);
    public abstract void deleteById(ID entityId);
    public abstract void deleteAll();
}
