package ci.doci.colis.service;

import ci.doci.colis.domaine.Agence;
import ci.doci.colis.domaine.dto.AgenceDto;

import java.util.List;

public interface AgenceService {
    AgenceDto saveAgence(AgenceDto agenceDto);
    List<AgenceDto> getAllAgence();
    AgenceDto findById(Long id);
    AgenceDto update(AgenceDto agenceDto);
    void deleteAgence(Long id);
}
