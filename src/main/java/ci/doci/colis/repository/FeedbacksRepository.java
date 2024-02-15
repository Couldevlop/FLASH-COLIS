package ci.doci.colis.repository;

import ci.doci.colis.domaine.FeedBacks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbacksRepository extends JpaRepository<FeedBacks, Long> {
}
