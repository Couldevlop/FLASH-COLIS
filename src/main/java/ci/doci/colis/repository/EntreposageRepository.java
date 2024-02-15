package ci.doci.colis.repository;

import ci.doci.colis.domaine.Entreposage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntreposageRepository extends JpaRepository<Entreposage, Long> {
}
