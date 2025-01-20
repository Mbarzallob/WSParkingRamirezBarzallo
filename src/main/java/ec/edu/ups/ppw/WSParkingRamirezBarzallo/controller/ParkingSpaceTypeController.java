package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.ParkingSpaceType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/parkingSpaceType")
public class ParkingSpaceTypeController {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParkingSpaceType(){
        try
        {
            List<ParkingSpaceType> parkingSpaceType = new ArrayList<ParkingSpaceType>();
            return Response.ok(parkingSpaceType).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
