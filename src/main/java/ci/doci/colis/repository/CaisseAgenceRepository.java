package ci.doci.colis.repository;

import ci.doci.colis.domaine.CaisseAgence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaisseAgenceRepository extends JpaRepository<CaisseAgence, Long> {
}
