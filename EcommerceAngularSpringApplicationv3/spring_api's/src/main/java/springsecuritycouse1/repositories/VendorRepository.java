package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecuritycouse1.entities.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor , Long> {
}
