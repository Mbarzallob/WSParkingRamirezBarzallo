package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Status;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Role> getRoles() {
        String query = "SELECT p FROM Role p";
        TypedQuery<Role> q = em.createQuery(query, Role.class);
        return q.getResultList();
    }

    public List<Status> getStatuses() {
        String query = "SELECT p FROM Status p";
        TypedQuery<Status> q = em.createQuery(query, Status.class);
        return q.getResultList();
    }


}
