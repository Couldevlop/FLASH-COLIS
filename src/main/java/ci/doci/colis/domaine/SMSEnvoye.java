package ci.doci.colis.domaine;

import ci.doci.colis.Enum.SmsStatut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_smsenvoye")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SMSEnvoye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Colis colis;
    @ManyToOne
    private User user;
    private String message;
    private String destinataire;
    @Column(name = "dateenvoie")
    private LocalDateTime dateEnvoye;
    @Enumerated
    private SmsStatut statut;
}
