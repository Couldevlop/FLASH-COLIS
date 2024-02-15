package ci.doci.colis.repository;


import ci.doci.colis.domaine.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgenceRepository extends JpaRepository<Agence, Long> {

    @Query(value = "select max(i.id) as maxid from Agence i")
    Long getLastId();

    Agence findByNom(String nom);
}
