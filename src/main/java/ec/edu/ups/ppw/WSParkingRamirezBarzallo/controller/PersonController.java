package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person.VehicleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person.PersonService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

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
    @Path("/vehicle/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response addVehicle(@PathParam("personId") int personId, @Valid VehicleRequest vehicle){
        var result = personService.addVehicleToPerson(personId, vehicle);
        return Response.ok(result).build();
    }


}
