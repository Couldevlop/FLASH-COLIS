package ci.doci.colis.domaine.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class AxeTransportDto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double distance;
    @Column(name = "tempsestime")
    private String tempsEstime;
}
