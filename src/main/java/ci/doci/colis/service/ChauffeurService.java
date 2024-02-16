package ci.doci.colis.service;

import ci.doci.colis.domaine.dto.AgenceDto;
import ci.doci.colis.domaine.dto.ChauffeurDto;

import java.util.List;

public interface ChauffeurService {
    ChauffeurDto saveAgence(ChauffeurDto chauffeurDto);
    List<ChauffeurDto> getAllAgence();
    ChauffeurDto findById(Long id);
    ChauffeurDto update(ChauffeurDto chauffeurDto);
    void deleteChauffeur(Long id);
}
