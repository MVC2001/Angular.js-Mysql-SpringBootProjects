package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Inventory;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByNameContainingIgnoreCaseOrProductContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String name, String product, String category
    );
}