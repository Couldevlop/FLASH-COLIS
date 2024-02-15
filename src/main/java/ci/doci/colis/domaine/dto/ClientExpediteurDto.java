package ci.doci.colis.domaine.dto;

import ci.doci.colis.domaine.Clients;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "colis_clientexpediteur")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientExpediteurDto extends Clients {
    private LocalDateTime dateExp;
}
