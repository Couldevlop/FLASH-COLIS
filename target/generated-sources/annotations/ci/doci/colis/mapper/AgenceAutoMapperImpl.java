package ci.doci.colis.mapper;

import ci.doci.colis.domaine.Agence;
import ci.doci.colis.domaine.dto.AgenceDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-15T21:20:09+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class AgenceAutoMapperImpl implements AgenceAutoMapper {

    @Override
    public Agence mapToEntity(AgenceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Agence.AgenceBuilder agence = Agence.builder();

        agence.id( dto.getId() );
        agence.nom( dto.getNom() );
        agence.localisation( dto.getLocalisation() );
        agence.ville( dto.getVille() );
        agence.email( dto.getEmail() );
        agence.contact( dto.getContact() );
        agence.type( dto.getType() );

        return agence.build();
    }

    @Override
    public AgenceDto mapToDto(Agence agence) {
        if ( agence == null ) {
            return null;
        }

        AgenceDto agenceDto = new AgenceDto();

        agenceDto.setId( agence.getId() );
        agenceDto.setNom( agence.getNom() );
        agenceDto.setLocalisation( agence.getLocalisation() );
        agenceDto.setVille( agence.getVille() );
        agenceDto.setEmail( agence.getEmail() );
        agenceDto.setType( agence.getType() );
        agenceDto.setContact( agence.getContact() );

        return agenceDto;
    }
}
