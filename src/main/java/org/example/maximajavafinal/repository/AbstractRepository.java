package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AbstractRepository<T extends AbstractEntity, ID extends Serializable>  extends JpaRepository<T, ID> {
}
