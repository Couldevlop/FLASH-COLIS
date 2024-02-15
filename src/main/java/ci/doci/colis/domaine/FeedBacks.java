package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "colis_feedbacks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedBacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Colis colis;
    @ManyToOne
    private User user;
    private String commentaire;
    private String note;
    private LocalDateTime dateEng;
}
