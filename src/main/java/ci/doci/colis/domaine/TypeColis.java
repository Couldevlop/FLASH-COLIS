package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "colis_typecolis")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeColis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomtypecolis")
    private String nomTypeColis;
    private String description;
}
