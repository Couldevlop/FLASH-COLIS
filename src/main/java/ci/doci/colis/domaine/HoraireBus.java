package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_horairebus")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoraireBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AxeTransport axeTransport;
    @ManyToOne
    private Bus bus;
    @ManyToOne
    private Chauffeur chauffeur;
    @Column(name = "heuredepart")
    private LocalDateTime heureDepart;
    @Column(name = "heurearrivee")
    private LocalDateTime heureArrivee;

}
