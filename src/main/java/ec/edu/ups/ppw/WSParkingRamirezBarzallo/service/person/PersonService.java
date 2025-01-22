package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;



    public Response getGenders(){
        try{
            List<Gender> genders = personRepository.getGenders();
            return Response.ok(genders).build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
