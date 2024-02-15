package ci.doci.colis.repository;

import ci.doci.colis.domaine.Agence;
import ci.doci.colis.domaine.ClientExpediteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsExpediteurRepository extends JpaRepository<ClientExpediteur, Long> {

}
