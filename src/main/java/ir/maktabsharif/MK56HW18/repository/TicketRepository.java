package ir.maktabsharif.MK56HW18.repository;

import ir.maktabsharif.MK56HW18.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
