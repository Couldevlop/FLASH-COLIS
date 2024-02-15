package ci.doci.colis.domaine.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
public class ChauffeurDto {
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
