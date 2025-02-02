package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth.LoginRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.auth.RegisterRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.auth.AuthService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthController {

    @Inject
    private AuthService authService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid LoginRequest loginRequest) {
        var response = authService.login(loginRequest);
        return Response.ok(response).build();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid RegisterRequest registerRequest) {
        var response = authService.register(registerRequest);
        return Response.ok(response).build();
    }
}
