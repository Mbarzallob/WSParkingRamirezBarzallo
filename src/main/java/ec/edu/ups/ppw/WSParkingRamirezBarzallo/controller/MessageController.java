package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.other.Message;
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

@Path("/message")
public class MessageController {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages(){
        try
        {
            List<Message> messages = new ArrayList<Message>();
            return Response.ok(messages).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBlock(Message message){
        try
        {
            //TODO: LOGIC INSERT
            return Response.ok(message).build();
        }
        catch(Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBlock(@PathParam("messageId") int messageId,Message message){
        try
        {
            //TODO: LOGIC UPDATE
            return Response.ok(message).build();
        }
        catch(Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBlock(@PathParam("messageId") int messageId){
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
