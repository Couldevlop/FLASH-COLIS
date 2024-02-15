package ci.doci.colis.repository;

import ci.doci.colis.domaine.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {
}
