package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Gender> getGenders() {
        String query = "SELECT p FROM Gender p";
        TypedQuery<Gender> q = em.createQuery(query, Gender.class);
        return q.getResultList();
    }


}
