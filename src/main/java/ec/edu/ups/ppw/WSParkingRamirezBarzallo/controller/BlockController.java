package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking.BlockService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/block")
public class BlockController {

    @Inject
    private BlockService blockService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlocks(){
        var result = blockService.getBlocks();
        return Response.ok().entity(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBlock(@Valid BlockRequest block){
        var result = blockService.addBlock(block);
        return Response.ok().entity(result).build();
    }

    @DELETE
    @Path("/{blockId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBlock(@PathParam("blockId") int blockId){
        var result = blockService.removeBlock(blockId);
        return Response.ok().entity(result).build();
    }

}
