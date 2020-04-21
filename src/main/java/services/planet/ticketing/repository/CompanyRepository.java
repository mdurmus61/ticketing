package services.planet.ticketing.repository;

import services.planet.ticketing.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);
}
