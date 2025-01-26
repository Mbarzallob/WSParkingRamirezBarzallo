package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.message;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.other.Message;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.message.MessageRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.message.MessageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MessageService {


    @Inject
    MessageRepository messageRepository;

    public Result<Void> addMessage( MessageRequest message) {
        try{
            Message newMessage = new Message();
            newMessage.setMessage(message.getMessage());
            newMessage.setEmail(message.getEmail());
            newMessage.setName(message.getName());
            messageRepository.addMessage(newMessage);
            return Result.ok();
        }
        catch (Exception e) {
            return Result.failure(e.getMessage());
        }

    }

    public Result<List<Message>> getMessages() {
        try{
            List<Message> messages = messageRepository.getMessages();
            return Result.success(messages);
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }

    }

}
