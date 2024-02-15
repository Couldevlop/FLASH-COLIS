package ci.doci.colis.domaine;

import ci.doci.colis.Enum.StatutCaisse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_caisseAgence")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaisseAgence {
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
