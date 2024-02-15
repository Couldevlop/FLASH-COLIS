package ci.doci.colis.service.Impl;

import ci.doci.colis.domaine.Agence;
import ci.doci.colis.domaine.dto.AgenceDto;
import ci.doci.colis.exception.BadActionException;
import ci.doci.colis.exception.NullableException;
import ci.doci.colis.exception.ResourceAlReadyExistsException;
import ci.doci.colis.mapper.AgenceAutoMapper;
import ci.doci.colis.repository.AgenceRepository;
import ci.doci.colis.service.AgenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgenceServiceImpl implements AgenceService {
    private final AgenceRepository agenceRepository;


    public AgenceServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public AgenceDto saveAgence(AgenceDto agenceDto) {
        if(agenceDto == null){
            throw new NullableException("L'objet fourni est null");
        }
        if(agenceRepository.findByNom(agenceDto.getNom()) != null){
            throw new ResourceAlReadyExistsException("Désolé, une agence existe avec ce nom " + agenceDto.getNom());
        }
        return AgenceAutoMapper.INSTANCE.mapToDto(agenceRepository.save(AgenceAutoMapper.INSTANCE.mapToEntity(agenceDto)));
    }

    @Override
    public List<AgenceDto> getAllAgence() {
        return agenceRepository.findAll().stream().map(AgenceAutoMapper.INSTANCE::mapToDto).collect(Collectors.toList());
    }

    @Override
    public AgenceDto findById(Long id) {
        return null;
    }

    @Override
    public AgenceDto update(AgenceDto agenceDto) {
        return null;
    }

    @Override
    public void deleteAgence(Long id) {

    }
}
