package ci.doci.colis.repository;

import ci.doci.colis.domaine.Role;
import ci.doci.colis.domaine.User;
import ci.doci.colis.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findByActivatedIsFalseAndLogin(String login);
    //Boolean findUserByActivatedLogin(String login);

    Optional<User> findByLogin(String login);

    List<User> findByRoles(Role role);

    //List<User> findByAgence_NomAgence(String nomAgence);

    @Query("select u.email from User u")
    List<String> findAllEmail();

    User findUserByUsernameEquals(String nom);



    @Query(value = "SELECT * from ci_user_roles where user_id=:id", nativeQuery = true)
    Role touverRole(@Param("id") Long id);



   // List<User>findBySite(String site);





}
