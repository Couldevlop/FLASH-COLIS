package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "colis_vehicule")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String immatricule;
    private String marque;
    private String model;
    @Column(name = "anneemisecircul")
    private LocalDate anneeMiseCirculation;
    private String chauffeur;
    @Column(name = "gpsactif")
    private boolean gps_actif;
}
