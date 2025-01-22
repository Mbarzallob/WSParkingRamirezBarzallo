package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.message;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.other.Message;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.message.MessageRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.message.MessageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class MessageService {
    @Inject
    MessageRepository messageRepository;

    public Response addMessage(MessageRequest message) {
        try{
            Message newMessage = new Message();
            newMessage.setMessage(message.getMessage());
            newMessage.setEmail(message.getEmail());
            newMessage.setName(message.getName());
            messageRepository.addMessage(newMessage);
            return Response.status(Response.Status.CREATED).build();
        }
        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }

    }

    public Response getMessages() {
        try{
            List<Message> messages = messageRepository.getMessages();
            return Response.status(Response.Status.OK).entity(messages).build();
        }catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }

    }

}
