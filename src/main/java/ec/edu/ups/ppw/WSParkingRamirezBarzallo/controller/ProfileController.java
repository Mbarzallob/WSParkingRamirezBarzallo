package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.Profile;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.ProfileRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person.PersonService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import java.security.Principal;

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

}
