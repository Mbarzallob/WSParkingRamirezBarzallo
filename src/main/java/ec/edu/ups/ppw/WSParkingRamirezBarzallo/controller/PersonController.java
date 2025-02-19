package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person.VehicleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person.PersonService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/person")
public class PersonController {
    @Inject
    private PersonService personService;

    @GET
    @Path("/gender")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGenders(){
        var result = personService.getGenders();
        return Response.ok().entity(result).build();
    }


    @GET
    @Path("/vehicle/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehicles(@PathParam("personId") int personId){
        var result = personService.getVehicles(personId);
        return Response.ok(result).build();
    }

    @POST
    @Path("/vehicle/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVehicle(@PathParam("userId") int userId, @Valid VehicleRequest vehicle){
        var result = personService.addVehicleToPerson(userId, vehicle);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/vehicle/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteVehicle(@PathParam("id") int id){
        var result = personService.removeVehicle(id);
        return Response.ok(result).build();
    }
}
