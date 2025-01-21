package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Status;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.admin.UserRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/user")
public class UserController {

    @GET
    @Path("/role")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoles(){
        try
        {
            List<Role> roles = new ArrayList<Role>();
            return Response.ok(roles).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatuses(){
        try
        {
            List<Status> statuses = new ArrayList<Status>();
            return Response.ok(statuses).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        return Response.ok(new ArrayList<User>()).build();
    }

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") int userId, UserRequest user){
        return Response.ok(user).build();
    }
}
