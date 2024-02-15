package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "doci_client_doci")
@MappedSuperclass
public  class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String email;
    private String contact1;
    private LocalDate dateEnreg;
    private String localisation;
    private String typePiece;
    private String numPiece;
    @ManyToOne
    private Agence agence;
    @ManyToOne
    private User user;

}
