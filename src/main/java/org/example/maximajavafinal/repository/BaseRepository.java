package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends JpaRepository <Model, Long>{
}
