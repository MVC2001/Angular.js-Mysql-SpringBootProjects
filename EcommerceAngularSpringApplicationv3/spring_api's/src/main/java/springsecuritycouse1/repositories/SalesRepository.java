package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecuritycouse1.entities.Carts;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Carts, Long> {

    List<Carts> findByConfirmed(String confirmedStatus);

}
