package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionRepository extends JpaRepository <Exhibition, Long> {
}
