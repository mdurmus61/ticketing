package services.planet.ticketing.repository;

import services.planet.ticketing.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight findByCompanyNameAndRouteDepartureNameAndRouteArrivalNameAndDepartureTimeAndArrivalTime(String companyName, String departureName, String arrivalName, OffsetDateTime departureTime, OffsetDateTime arrivalTime);
    Flight findOneById(Long id);

    @Query(value = "select f from Flight f where"
            + " (:companyName IS NULL OR f.company.name = :companyName) AND"
            + " (:departureName IS NULL OR f.route.departure.name= :departureName) AND"
            + " (:arrivalName IS NULL OR f.route.arrival.name= :arrivalName) AND"
            + " (:departureTime IS NULL OR f.departureTime >= :departureTime) AND"
            + " (:arrivalTime IS NULL OR f.arrivalTime <= :arrivalTime)")
    List<Flight> findAllByParams(@Param("companyName") String companyName, @Param("departureName") String departureName, @Param("arrivalName") String arrivalName,
                                 @Param("departureTime") OffsetDateTime departureTime, @Param("arrivalTime") OffsetDateTime arrivalTime);
}
