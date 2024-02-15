package ci.doci.colis.repository;

import ci.doci.colis.domaine.ClientDestinataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<ClientDestinataire, Long> {
}
