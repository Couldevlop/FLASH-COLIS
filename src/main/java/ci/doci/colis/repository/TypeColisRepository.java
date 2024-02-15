package ci.doci.colis.repository;

import ci.doci.colis.domaine.TypeColis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeColisRepository extends JpaRepository<TypeColis, Long> {
}
