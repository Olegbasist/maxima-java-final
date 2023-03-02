package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AbstractBaseRepository <T extends AbstractBaseEntity, ID extends Serializable>  extends JpaRepository<T, ID> {
}
