package ci.doci.colis.repository;

import ci.doci.colis.domaine.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
