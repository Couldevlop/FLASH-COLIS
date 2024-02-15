package ci.doci.colis.domaine;

import ci.doci.colis.Enum.EtatHisto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_historiquecolis")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoriqueColis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Colis colis;
    @ManyToOne
    private Escale escale;
    @ManyToOne
    private AxeTransport axe;
    @Enumerated
    private EtatHisto etat;
    @Column(name = "datemiseajour")
    private LocalDateTime dateMiseAJour;
}
