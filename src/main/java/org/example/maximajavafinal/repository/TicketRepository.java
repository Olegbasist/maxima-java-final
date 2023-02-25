package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {
}
