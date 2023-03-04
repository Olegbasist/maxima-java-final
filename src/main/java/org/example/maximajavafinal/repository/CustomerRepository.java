package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CustomerRepository <T extends Customer, ID extends Serializable>  extends JpaRepository<T, ID> {
}
