package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;


import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.Status;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/status")
public class StatusController {
    @GET
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
}
