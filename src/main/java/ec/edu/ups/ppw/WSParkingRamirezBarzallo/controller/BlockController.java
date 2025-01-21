package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/block")
public class BlockController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBlocks(){
        try
        {
            List<Block> blocks = new ArrayList<Block>();
            return Response.ok(blocks).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBlock(BlockRequest block){
        try
        {
            return Response.ok().build();
        }
        catch(Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{blockId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBlock(@PathParam("blockId") int blockId){
        try
        {
            return Response.ok().build();
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
