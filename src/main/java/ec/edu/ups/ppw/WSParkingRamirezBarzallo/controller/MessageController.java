package ec.edu.ups.ppw.WSParkingRamirezBarzallo.controller;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.other.Message;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.message.MessageRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.message.MessageService;
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

@Path("/message")
public class MessageController {

    @Inject
    private MessageService messageService;

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages(){
        var result =  messageService.getMessages();
        return Response.ok(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(MessageRequest message){
        var result = messageService.addMessage(message);
        return Response.ok(result).build();

    }

}
