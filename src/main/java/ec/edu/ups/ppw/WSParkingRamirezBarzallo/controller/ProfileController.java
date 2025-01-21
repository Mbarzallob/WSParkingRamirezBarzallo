package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.Profile;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.ProfileRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/profile")
public class ProfileController {
    @GET
    @Path("/profile/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfile(@PathParam("userId") int userId){
        return Response.ok(new Profile()).build();
    }

    @PUT
    @Path("/profile/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(@PathParam("userId") int userId, ProfileRequest profile){
        return Response.ok().build();
    }
}
