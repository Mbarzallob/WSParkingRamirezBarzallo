package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.*;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person.VehicleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.Profile;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.ProfileRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.PersonRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;
    @Inject
    UserRepository userRepository;




    public Result<List<Gender>> getGenders(){
        try{
            return Result.success(personRepository.getGenders()) ;
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> updateProfile(ProfileRequest request, int userId){
        try{
            User user =  userRepository.getUser(userId);
            personRepository.updateProfile(request, user.getPerson().getId());
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<Profile> getProfile(int userId){
        try{
            User user = userRepository.getUser(userId);
            Person person = personRepository.getPerson(user.getPerson().getId());
            Profile profile = new Profile();
            profile.setEmail(person.getEmail());
            profile.setFirstName(person.getFirstName());
            profile.setLastName(person.getLastName());
            profile.setFechaNacimiento(person.getBirthDate());
            profile.setPhoneNumber(person.getPhoneNumber());
            return Result.success(profile);
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> addVehicleToPerson(int userId, VehicleRequest request){
        try {
            int personId = personRepository.getPerson(userRepository.getUser(userId).getPerson().getId()).getId();
            var type = personRepository.getVehicleType(request.getType());
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(type);
            vehicle.setModel(request.getModel());
            vehicle.setPlate(request.getPlate());
            personRepository.addVehicleToPerson(personId, vehicle);
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<Vehicle>> getVehicles(int personId){
        try{
            return Result.success(personRepository.getPersonWithVehicles(personId).getVehicles());
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> removeVehicle(int vehicleId){
        try{
            var tickets = personRepository.ticketsWithVehicle(vehicleId);
            if(!tickets.isEmpty()){
                return Result.failure("No se puede eliminar el ticket porque tiene tickets asociados");
            }
            personRepository.removeVehicle(vehicleId);
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

}
