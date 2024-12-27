package Applications.repositories;

import Applications.models.StreamingLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingLinkRepository extends JpaRepository<StreamingLink, Long> {
}
