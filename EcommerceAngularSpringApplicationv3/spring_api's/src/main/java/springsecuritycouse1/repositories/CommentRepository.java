package springsecuritycouse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecuritycouse1.entities.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
}
