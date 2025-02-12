package ec.edu.ups.ppw.WSParkingRamirezBarzallo.view;


import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.other.Message;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.message.MessageRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.message.MessageService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("messages")
@RequestScoped
public class MessageBean {
    @Inject
    private MessageService messageService;

    private MessageRequest message = new MessageRequest();

    private List<Message> messages;

    @PostConstruct
    public void init(){
        messages = messageService.getMessages().getData();
    }


    public MessageRequest getMessage() {
        return message;
    }

    public void setMessage(MessageRequest message) {
        this.message = message;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String guardar(){
        try{

            messageService.addMessage(message);
            return "messageList?faces-redirect=true";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
