package ci.doci.colis.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "colis_clientdestinataire")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDestinataire extends Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRecep;



}
