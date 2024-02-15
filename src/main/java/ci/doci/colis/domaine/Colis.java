package ci.doci.colis.domaine;

import ci.doci.colis.Enum.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_colis")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ClientDestinataire clientDestinataire;

    @ManyToOne
    private ClientExpediteur clientExpediteur;
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
