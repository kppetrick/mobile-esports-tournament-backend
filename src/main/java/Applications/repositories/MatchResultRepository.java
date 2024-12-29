package Applications.repositories;

import Applications.models.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchResultRepository extends JpaRepository<MatchResult, Long> {
    // Custom query methods here (if needed)
}
