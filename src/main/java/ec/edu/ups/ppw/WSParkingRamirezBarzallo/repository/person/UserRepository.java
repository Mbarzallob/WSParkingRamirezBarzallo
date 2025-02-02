package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Status;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Stateless
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Role> getRoles() {
        String query = "SELECT p FROM Role p";
        TypedQuery<Role> q = em.createQuery(query, Role.class);
        return q.getResultList();
    }

    public Role getRole(int id) {
        return em.find(Role.class, id);
    }

    public Status getStatus(int id) {
        return em.find(Status.class, id);
    }

    public List<Status> getStatuses() {
        String query = "SELECT p FROM Status p";
        TypedQuery<Status> q = em.createQuery(query, Status.class);
        return q.getResultList();
    }

    public void addUser(User user) {
        em.persist(user);
    }

    public List<User> getUsers() {
        String query = "SELECT p FROM User p";
        TypedQuery<User> q = em.createQuery(query, User.class);
        return q.getResultList();
    }

    public User getUserByUsername(String username) {
        String query = "SELECT p FROM User p WHERE p.username=:username";
        try{
            return em.createQuery(query, User.class).setParameter("username", username).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }


}
