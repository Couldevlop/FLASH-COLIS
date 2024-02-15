package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colis_interim")
public class Interim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String interimaire;
    private String titulaire;
    private String debut;
    private String fin;
}
