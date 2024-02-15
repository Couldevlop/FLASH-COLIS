package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "colis_axetransport")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AxeTransport {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double distance;
    @Column(name = "tempsestime")
    private String tempsEstime;
}
