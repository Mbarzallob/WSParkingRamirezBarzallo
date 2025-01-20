package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.Message;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/gender")
public class GenderController {
    @GET
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

}
