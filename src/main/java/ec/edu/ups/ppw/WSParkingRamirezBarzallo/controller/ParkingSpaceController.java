package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpaceType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceTypeRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/parkingSpace")
public class ParkingSpaceController {

	@GET
    @Path("/{blockId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParkingSpaces(@PathParam("blockId") int blockId){
        try
        {
            List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();
            return Response.ok(parkingSpaces).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBlock( ParkingSpaceRequest parkingSpace){
        try
        {
            //TODO: LOGIC INSERT
            return Response.ok(parkingSpace).build();
        }
        catch(Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @GET
    @Path("/types")
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
    @PUT
    @Path("/types/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateParkingSpaceType(@PathParam("typeId") int typeId, ParkingSpaceTypeRequest request){
        try
        {

            return Response.ok(request).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
