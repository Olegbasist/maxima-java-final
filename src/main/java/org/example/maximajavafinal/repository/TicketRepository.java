package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface TicketRepository <T extends Ticket, ID extends Serializable>  extends JpaRepository<T, ID> {
}
