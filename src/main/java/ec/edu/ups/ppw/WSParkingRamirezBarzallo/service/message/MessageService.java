package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.message;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.other.Message;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.message.MessageRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.message.MessageRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.utils.ValidationUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class MessageService {

    @Inject
    Validator validator;
    @Inject
    MessageRepository messageRepository;

    public Result<Void> addMessage( MessageRequest message) {
        try{
            ValidationUtils.validate(message, validator);
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
