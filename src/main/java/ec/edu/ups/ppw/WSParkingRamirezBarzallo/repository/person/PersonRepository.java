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

    public Optional<Person> getPersonByIdentification(String identification) {
        try {
            String query = "SELECT p FROM Person p WHERE p.identification=:identification";
            Person person  = em.createQuery(query, Person.class).setParameter("identification", identification).getSingleResult();
            return Optional.of(person);
        }catch(NoResultException e){
            return Optional.empty();
        }
    }


}
