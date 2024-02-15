package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "colis_imagecolis")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageColis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Colis colis;
    @Column(name = "urlimage")
    private String urlImage;
    private String description;
}
