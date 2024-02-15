package ci.doci.colis.mapper;

import ci.doci.colis.domaine.Agence;
import ci.doci.colis.domaine.dto.AgenceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgenceAutoMapper {
    AgenceAutoMapper INSTANCE = Mappers.getMapper(AgenceAutoMapper.class);

    Agence mapToEntity(AgenceDto dto);
    AgenceDto mapToDto(Agence agence);
}
