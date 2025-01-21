package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth.LoginRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth.RegisterRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("auth")
public class AuthController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {
        return Response.ok(new User()).build();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(RegisterRequest registerRequest) {
        return Response.ok().build();
    }
}
