package services.planet.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import services.planet.ticketing.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
