package ci.doci.colis.repository;

import ci.doci.colis.domaine.HistoriqueColis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueColisRepository extends JpaRepository<HistoriqueColis, Long> {
}
