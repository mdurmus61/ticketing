package services.planet.ticketing.repository;

import services.planet.ticketing.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Route findByDepartureNameAndArrivalName(String departureName, String arrivalName);

    @Query(value = "select r from Route r where"
            + " (:departureName IS NULL OR r.departure.name = :departureName) AND"
            + " (:arrivalName IS NULL OR r.arrival.name= :arrivalName)")
    List<Route> findAllByParams(@Param("departureName") String departureName, @Param("arrivalName") String arrivalName);
}
