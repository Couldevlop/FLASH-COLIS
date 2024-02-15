package ci.doci.colis.repository;

import ci.doci.colis.domaine.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
}
