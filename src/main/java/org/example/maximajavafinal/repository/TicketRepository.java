package org.example.maximajavafinal.repository;

import org.example.maximajavafinal.model.Customer;
import org.example.maximajavafinal.model.Excursion;
import org.example.maximajavafinal.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {

    List<Ticket> findByCustomer_IdAndExcursion_Id (long customerId, long excursionId);

    List<Ticket> findByCustomerAndExcursion (Customer customer, Excursion excursion);
}
