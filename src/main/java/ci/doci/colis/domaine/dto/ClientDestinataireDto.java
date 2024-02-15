package ci.doci.colis.domaine.dto;

import ci.doci.colis.domaine.Clients;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ClientDestinataireDto extends Clients {
    private LocalDateTime dateRecep;



}
