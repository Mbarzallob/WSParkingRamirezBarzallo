package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person.VehicleRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/person")
public class PersonController {
    @GET
    @Path("/gender")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGenders(){
        try
        {
            List<Gender> genders = new ArrayList<Gender>();
            return Response.ok(genders).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @GET
    @Path("/vehicle/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehicles(@PathParam("personId") int personId){
        List<Vehicle> vehicles = new ArrayList<>();
        return Response.ok(vehicles).build();
    }

    @POST
    @Path("/vehicle/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVehicle(@PathParam("personId") int personId, VehicleRequest vehicle){
        return Response.ok().build();
    }


}
