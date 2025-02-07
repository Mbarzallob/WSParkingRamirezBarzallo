package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.auth;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Person;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth.LoginRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth.LoginResponse;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth.RegisterRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.PersonRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.UserRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils.JWTUtils;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils.Validations;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class AuthService {
    @Inject
    private PersonRepository personRepository;

    @Inject
    private UserRepository  userRepository;

    @Transactional
    public Result<Void> register(RegisterRequest registerRequest){
        try {
            User existsUsuario = userRepository.getUserByUsername(registerRequest.getUsername());
            if(existsUsuario != null){
                return Result.failure("Usuario ya existe");
            }
            Person existsPerson = personRepository.getPersonByIdentification(registerRequest.getIdentification());
            if(existsPerson != null){
                return Result.failure("Persona ya existe");
            }
            boolean validPasword = Validations.validatePassword(registerRequest.getPassword());
            System.out.println(validPasword);
            if(!validPasword){
                return Result.failure("Contraseña invalida");
            }
            Person person = new Person();
            person.setIdentification(registerRequest.getIdentification());
            person.setEmail(registerRequest.getEmail());
            person.setFirstName(registerRequest.getFirstName());
            person.setLastName(registerRequest.getLastName());
            person.setBirthDate(registerRequest.getDateOfBirth());
            person.setPhoneNumber(registerRequest.getPhone());
            person.setGender(personRepository.getGenderById(registerRequest.getGenderId()));
            personRepository.addPerson(person);
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(registerRequest.getPassword());
            user.setCreationDate(LocalDate.now());
            user.setPerson(person);
            user.setStatus(userRepository.getStatus(1));
            user.setRole(userRepository.getRole(3));
            userRepository.addUser(user);

            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }

    }

    public Result<LoginResponse> login(LoginRequest loginRequest){
        try{
            User user = userRepository.getUserByUsername(loginRequest.getUsername());
            if(user ==null){
                return Result.failure("Usuario o contraseña invalido");
            }
            if(!user.getPassword().equals(loginRequest.getPassword())){
                return Result.failure("Usuario o contraseña invalido");
            }
            String jwt = JWTUtils.generarToken(user.getId(), user.getRole().getId());
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setRol(user.getRole().getId());
            loginResponse.setJWT(jwt);
            return Result.success(loginResponse);
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }
}
