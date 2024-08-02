package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecuritycouse1.entities.AddToCart;

public interface CartRepository extends JpaRepository<AddToCart, Long> {
}
