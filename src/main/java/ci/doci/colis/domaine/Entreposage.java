package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_entreposage")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entreposage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Colis colis;
    private String rayon;
    private String etagere;
    private String position;
    private LocalDateTime dateEntrepo;
}
