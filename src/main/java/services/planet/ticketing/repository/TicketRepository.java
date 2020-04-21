package services.planet.ticketing.repository;

import services.planet.ticketing.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findByTicketNumber(String ticketNumber);
}
