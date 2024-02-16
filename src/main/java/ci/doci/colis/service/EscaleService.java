package ci.doci.colis.service;

import ci.doci.colis.domaine.dto.AgenceDto;
import ci.doci.colis.domaine.dto.EscaleDto;

import java.util.List;

public interface EscaleService {
    EscaleDto saveEscale(EscaleDto escaleDto);
    List<EscaleDto> getAllEscale();
    EscaleDto findById(Long id);
    EscaleDto update(EscaleDto escaleDto);
    void deleteEscale(Long id);
}
