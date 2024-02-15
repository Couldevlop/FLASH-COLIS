package ci.doci.colis.repository;

import ci.doci.colis.domaine.ClientDestinataire;
import ci.doci.colis.domaine.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDestinataireRepository extends JpaRepository<ClientDestinataire, Long> {


}
