package ci.doci.colis.domaine.dto;

import ci.doci.colis.domaine.Agence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StationsDTO {
    private Long id;
    private String nom;


    public static StationsDTO mapToDto(Agence agence){
        return StationsDTO.builder()
                .id(agence.getId())
                .nom(agence.getNom())
                .build();
    }



}


