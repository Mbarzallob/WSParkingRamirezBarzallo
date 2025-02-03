package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Person;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.VehicleType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.profile.ProfileRequest;
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

    public void updateProfile(ProfileRequest profileRequest, int personId) throws Exception {
        Person person = em.find(Person.class, personId);
        if(person == null){
            throw new Exception("Datos invalidos");
        }
        person.setFirstName(profileRequest.getFirstName());
        person.setLastName(profileRequest.getLastName());
        person.setEmail(profileRequest.getEmail());
        person.setBirthDate(profileRequest.getFechaNacimiento());
        person.setPhoneNumber(profileRequest.getPhoneNumber());
        em.merge(person);
        em.flush();
    }
    public Person getPersonWithVehicles(int personId) {
        return em.createQuery(
                        "SELECT p FROM Person p LEFT JOIN FETCH p.vehicles WHERE p.id = :id", Person.class)
                .setParameter("id", personId)
                .getSingleResult();
    }


    public Person getPerson(int userId){
        return em.find(Person.class, userId);
    }
    public void addVehicleToPerson(int personId, Vehicle newVehicle) {
        Person person = em.find(Person.class, personId);
        if (person == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        person.addVehicle(newVehicle);
        em.merge(person);
    }

    public VehicleType getVehicleType(int vehicleTypeId) {
        return em.find(VehicleType.class, vehicleTypeId);
    }
}
