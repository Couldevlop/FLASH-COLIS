package ci.doci.colis.service;

import ci.doci.colis.domaine.dto.AgenceDto;
import ci.doci.colis.domaine.dto.AxeTransportDto;

import java.util.List;

public interface AxeTransportService {
    AxeTransportDto saveAxeTransport(AxeTransportDto axeTransportDto);
    List<AxeTransportDto> getAllAxeTransport();
    AxeTransportDto findById(Long id);
    AxeTransportDto update(AxeTransportDto axeTransportDto);
    void deleteAxeTransport(Long id);
}
