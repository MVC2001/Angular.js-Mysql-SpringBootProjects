package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecuritycouse1.entities.AddToCart;

@Repository
public interface AddToCarRepository extends JpaRepository<AddToCart ,Long> {
}
