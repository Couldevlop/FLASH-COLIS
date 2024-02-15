package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_etape")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etape {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Colis colis;
    @ManyToOne
    private Escale escale;
    private LocalDateTime dateHeureArrivee;
    private LocalDateTime dateHeureDepart;
    private String commentaire;

}
