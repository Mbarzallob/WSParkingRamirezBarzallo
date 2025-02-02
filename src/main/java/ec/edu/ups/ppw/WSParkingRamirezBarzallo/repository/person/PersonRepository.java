package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Person;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Stateless
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Gender> getGenders() {
        String query = "SELECT p FROM Gender p";
        TypedQuery<Gender> q = em.createQuery(query, Gender.class);
        return q.getResultList();
    }

    public Gender getGenderById(int id) {
        return em.find(Gender.class, id);
    }

    public void addPerson(Person person) {
        em.persist(person);
    }

    public Person getPersonByIdentification(String identification) {
        String query = "SELECT p FROM Person p WHERE p.identification=:variabel";
        try{
             return em.createQuery(query, Person.class).setParameter("variabel", identification).getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }


}
