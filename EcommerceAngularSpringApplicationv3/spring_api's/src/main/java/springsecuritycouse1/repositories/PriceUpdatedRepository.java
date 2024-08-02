package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecuritycouse1.entities.PriceUpdates;

@Repository
public interface PriceUpdatedRepository  extends JpaRepository<PriceUpdates, Long> {
}
