package ci.doci.colis.domaine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
public class EtapeDto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ColisDto colis;
    @ManyToOne
    private EscaleDto escale;
    private LocalDateTime dateHeureArrivee;
    private LocalDateTime dateHeureDepart;
    private String commentaire;

}
