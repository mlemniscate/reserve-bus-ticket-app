package ir.maktabsharif.MK56HW18.repository;

import ir.maktabsharif.MK56HW18.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUser_Username(String username);
}
