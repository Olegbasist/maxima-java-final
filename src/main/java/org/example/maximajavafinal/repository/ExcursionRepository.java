package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcursionRepository extends JpaRepository <Excursion, Long> {
    List<Excursion> findByTitleContainingIgnoreCase (String name);
    List<Excursion> findByGuide_Id (long id);
}
