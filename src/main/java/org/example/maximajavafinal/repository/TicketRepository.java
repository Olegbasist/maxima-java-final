package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Long> {
}
