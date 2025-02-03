package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpaceType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceTypeRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking.ParkingService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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

@Path("/parking")
public class ParkingSpaceController {

    @Inject
    private ParkingService parkingService;

	@GET
    @Path("/{blockId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParkingSpaces(@PathParam("blockId") int blockId){
        var result = parkingService.getParkingSpacesByBlock(blockId);
        return Response.ok(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addParkingSpace(@Valid ParkingSpaceRequest parkingSpace){
        var result = parkingService.addParkingSpace(parkingSpace);
        return Response.ok(result).build();
    }


    @GET
    @Path("/types")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParkingSpaceType(){
        var result = parkingService.getParkingSpaceTypes();
        return Response.ok(result).build();
    }
    @PUT
    @Path("/types/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateParkingSpaceType(@PathParam("typeId") int typeId,@Valid ParkingSpaceTypeRequest request){
        var result = parkingService.updateParkingSpaceType(request, typeId);
        return Response.ok(result).build();
    }
}
