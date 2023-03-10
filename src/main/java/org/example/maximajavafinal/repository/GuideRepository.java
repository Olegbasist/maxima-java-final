package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository <Guide, Long> {
    List<Guide> findByNameContainingIgnoreCase (String name);
}
