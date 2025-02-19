package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person.UserRoleRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Path("/user")
public class UserController {

    @Inject
    private UserService userService;


    @GET
    @Path("/role")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoles(){
        var result = userService.getRoles();
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatuses(){
        var result = userService.getStatuses();
        return Response.ok().entity(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(@Context SecurityContext sc){
        if(!sc.isUserInRole("1")){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        var result = userService.getUsers();
        return Response.ok().entity(result).build();
    }

    @PUT
    @Path("/role")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserRole (UserRoleRequest request,@Context SecurityContext sc){
        if(!sc.isUserInRole("1")){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        var result = userService.updateUserRole(request);
        return Response.ok().entity(result).build();
    }


}
