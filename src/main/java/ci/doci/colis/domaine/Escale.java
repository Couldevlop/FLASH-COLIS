package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_escale")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Escale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String ordre;
    @Column(name = "heurearriveeprevue")
    private LocalDateTime heureArriveePrevue;
    @Column(name = "heuredepartprevue")
    private LocalDateTime heureDepartPrevue;
}
