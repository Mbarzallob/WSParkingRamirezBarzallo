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
        return blockService.getBlocks();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBlock(@Valid BlockRequest block){
        return blockService.addBlock(block);
    }

    @DELETE
    @Path("/{blockId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBlock(@PathParam("blockId") int blockId){
        return blockService.removeBlock(blockId);
    }

}
