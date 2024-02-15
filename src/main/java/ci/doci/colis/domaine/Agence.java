package ci.doci.colis.domaine;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "doci_agence")
@Builder
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String localisation;
    private String ville;
    private String email;
    private String contact;
    private String type;


}
