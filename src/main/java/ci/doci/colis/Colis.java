package ci.doci.colis;

import ci.doci.colis.domaine.Agence;
import ci.doci.colis.domaine.Role;
import ci.doci.colis.domaine.User;
import ci.doci.colis.domaine.dto.AgenceDto;
import ci.doci.colis.mapper.AgenceAutoMapper;
import ci.doci.colis.repository.RoleRepository;
import ci.doci.colis.repository.UserRepository;
import ci.doci.colis.service.AgenceService;
import ci.doci.colis.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Colis {
	@Autowired
    private AgenceService agenceService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;


	public static void main(String[] args) {
		SpringApplication.run(Colis.class, args);



	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	@Bean
     public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();

    }
	/*@Bean
	CommandLineRunner startUp(){
		return args -> {


			//Roles
			Role role = Role.builder()
					.name("ROLE_ADMIN")
					.description("ADMIN")
					.build();
          roleRepository.save(role);


			Role role1 = Role.builder()
					.name("ROLE_ADMIN")
					.description("USER")
					.build();
           roleRepository.save(role1);
		   List<Role> roleList = new ArrayList<>();
		   roleList.add(role);
		   roleList.add(role1);


			// agence
			Agence agence = Agence.builder()
					.nom("CHAPCOLIS")
					.ville("ABIDJAN")
					.localisation("Cocody")
					.build();
			AgenceDto agenceSaved = agenceService.saveAgence(AgenceAutoMapper.INSTANCE.mapToDto(agence));

			User user = User.builder()
					.email("coulwao@gmail.com")
					.activated(true)
					.contact("0709320594")
					.login("m1333")
					.firstConnection(false)
					.username("WAOPRON")
					.agence(AgenceAutoMapper.INSTANCE.mapToEntity(agenceSaved))
					.password(bCryptPasswordEncoder().encode("123456"))
					.roles(roleList)
					.build();

			userRepository.save(user);
		};
	}*/



}
