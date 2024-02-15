package ci.doci.colis.domaine;

import ci.doci.colis.Enum.StatutTrajet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_trajet")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trajet {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Colis colis;
    @ManyToOne
    private Vehicule vehicule;
    private LocalDateTime dateHeureDepart;
    private LocalDateTime dateHeureArrive;
    @Enumerated
    private StatutTrajet statutTrajet;
}
