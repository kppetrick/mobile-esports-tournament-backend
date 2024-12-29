package Applications.repositories;

import Applications.models.TournamentPlayer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TournamentPlayerRepository extends JpaRepository<TournamentPlayer, Long> {
    // Custom queries, if any
}
