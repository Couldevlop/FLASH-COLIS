package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "colis_etatcolisescale")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtatColisEscale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
