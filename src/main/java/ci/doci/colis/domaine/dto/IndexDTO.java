package ci.doci.colis.domaine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "doci_indexdto")
@Entity
public class IndexDTO {
    @Id
    @GeneratedValue
    private Long id;
    private String station;
    private LocalDate dateJour;
    private int totalPrise;
}
