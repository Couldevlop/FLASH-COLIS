package ci.doci.colis.domaine.dto;

import ci.doci.colis.Enum.StatutCaisse;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class CaisseAgenceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double solde;
    @Column(name = "dateOuverture")
    private LocalDateTime dateOuv;
    @Column(name = "datecloture")
    private LocalDateTime dateClo;
    private StatutCaisse statut;
}
