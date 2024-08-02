package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecuritycouse1.entities.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
