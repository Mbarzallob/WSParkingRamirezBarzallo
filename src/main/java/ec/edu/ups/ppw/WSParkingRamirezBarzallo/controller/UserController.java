package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Status;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.admin.UserRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.person.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

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
    public Response getUsers(){
        var result = userService.getUsers();
        return Response.ok().entity(result).build();
    }

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") int userId, UserRequest user){
        return Response.ok(user).build();
    }
}
