package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

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

//@Path("/parkingSpace")
//public class ParkingSpaceController {
//	
//	@GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getBlocks(){
//        try
//        {
//            List<Block> blocks = new ArrayList<Block>();
//            return Response.ok(blocks).build();
//        }
//        catch(Exception e){
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addBlock(Block block){
//        try
//        {
//            //TODO: LOGIC INSERT
//            return Response.ok(block).build();
//        }
//        catch(Exception e)
//        {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }
//    @PUT
//    @Path("/{blockId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateBlock(@PathParam("blockId") int blockId,Block block){
//        try
//        {
//            //TODO: LOGIC UPDATE
//            return Response.ok(block).build();
//        }
//        catch(Exception e)
//        {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }
//    @DELETE
//    @Path("/{blockId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteBlock(@PathParam("blockId") int blockId){
//        try
//        {
//            return Response.ok().build();
//        }
//        catch (Exception e)
//        {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }
//}
