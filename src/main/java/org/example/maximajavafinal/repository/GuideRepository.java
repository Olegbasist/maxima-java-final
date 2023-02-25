package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository <Guide, Long> {
}
