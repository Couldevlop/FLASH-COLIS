package ci.doci.colis.domaine.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
public class EntreposageDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ColisDto colis;
    private String rayon;
    private String etagere;
    private String position;
    private LocalDateTime dateEntrepo;
}
