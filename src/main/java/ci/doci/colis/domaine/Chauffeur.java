package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "colis_chauffeur")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chauffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(name = "numeropermis")
    private String numeroPermis;
    private String telephone;
    @Column(name = "datenais")
    private LocalDate dateNaiss;
    @Column(name = "datepermisexpiration")
    private LocalDate datePermisExpiration;
}
