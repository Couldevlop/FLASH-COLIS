package ci.doci.colis.domaine.dto;

import ci.doci.colis.Enum.Statut;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
public class ColisDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ClientDestinataireDto clientDestinataire;

    @ManyToOne
    private ClientExpediteurDto clientExpediteur;
    private Double poids;
    private Double longueur;
    private Double largeur;
    private Double voulume;
    private String typeContenu;
    private Double valeurDeclaree;
    @Enumerated
    private Statut statut;
    private LocalDateTime dateEnvoie;
    private LocalDateTime dateRecepPrevue;
    private LocalDateTime dateLivrReele;
}
