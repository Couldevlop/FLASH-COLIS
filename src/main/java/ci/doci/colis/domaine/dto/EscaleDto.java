package ci.doci.colis.domaine.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
public class EscaleDto {
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
