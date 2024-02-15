package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colis_zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String localisation;
    private String description;
    private LocalDate dateCreation;
    private String createBy;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Agence> agenceList;


}
