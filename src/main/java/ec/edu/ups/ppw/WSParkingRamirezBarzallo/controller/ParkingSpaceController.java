package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.FilterParkingSpaces;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceTypeRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking.ParkingService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/parking")
public class ParkingSpaceController {

    @Inject
    private ParkingService parkingService;

	@POST
    @Path("/block/{blockId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getParkingSpaces(@PathParam("blockId") int blockId, FilterParkingSpaces filter) {
        var result = parkingService.getParkingSpacesByBlock(blockId, filter);
        return Response.ok(result).build();
    }

    @GET
    @Path("/{parkingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParkingSpace(@PathParam("parkingId") int parkingId){
        var result = parkingService.getParkingSpaceById(parkingId);
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

    @POST
    @Path("/types")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addParkingType(@Valid ParkingSpaceTypeRequest request){
        var result = parkingService.addParkingSpaceType(request);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/types/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeParkingSpaceType(@PathParam("typeId") int typeId){
        var result = parkingService.deleteParkingSpaceType(typeId);
        return Response.ok(result).build();
    }

    @PUT
    @Path("/types/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateParkingSpaceType(@PathParam("typeId") int typeId,@Valid ParkingSpaceTypeRequest request){
        var result = parkingService.updateParkingSpaceType(request, typeId);
        return Response.ok(result).build();
    }

    @GET
    @Path("/vehicle/types")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParkingSpaceVehicleType(){
        var result = parkingService.getVehicleTypes();
        return Response.ok(result).build();
    }
}
