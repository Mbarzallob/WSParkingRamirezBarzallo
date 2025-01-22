package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.message;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.other.Message;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class MessageRepository {
    @PersistenceContext
    private EntityManager em;

    public void addMessage(Message message) {
        em.persist(message);
    }

    public List<Message> getMessages(){
        String jplql = "SELECT m FROM Message m";
        TypedQuery<Message> q = em.createQuery(jplql,Message.class);
        return q.getResultList();
    }

}
