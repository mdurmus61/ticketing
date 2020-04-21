package services.planet.ticketing.repository;

import services.planet.ticketing.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findOneByName(String name);
}
