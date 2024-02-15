package ci.doci.colis.service;

import ci.doci.colis.domaine.User;
import org.springframework.stereotype.Service;

@Service
public interface UtilisateurService {
    User update(Long userId, User us);
}
