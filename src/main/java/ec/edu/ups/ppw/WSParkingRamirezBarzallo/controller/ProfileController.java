package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.ProfileRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person.PersonService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;


@Path("/profile")
public class ProfileController {

     @Inject
    PersonService personService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfile(@Context SecurityContext requestContext){
        var result = personService.getProfile(Integer.parseInt(requestContext.getUserPrincipal().getName()));
        return Response.ok(result).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(@Context SecurityContext requestContext, @Valid ProfileRequest profile){
        var result = personService.updateProfile(profile, Integer.parseInt(requestContext.getUserPrincipal().getName()));
        return Response.ok(result).build();
    }

    @PUT
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserProfile(@Context SecurityContext sc, @PathParam("userId") int userId, @Valid ProfileRequest profile){
        if(!sc.isUserInRole("1")){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        var result = personService.updateProfile(profile, userId);
        return Response.ok(result).build();
    }

}
