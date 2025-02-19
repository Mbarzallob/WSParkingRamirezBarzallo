package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.config;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.VehicleType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ConfigRepository {
    @PersistenceContext
    private EntityManager em;

    public void addGender(Gender gender) {
        em.persist(gender);
    }

    public void addVehicleType(VehicleType vehicleType){
        em.persist(vehicleType);
    }

    public List<VehicleType> getAllVehicleTypes() {
        return em.createQuery("select vt from VehicleType vt", VehicleType.class).getResultList();
    }

    public List<Gender> getAllGenders() {
        return em.createQuery("select g from Gender g", Gender.class).getResultList();
    }
}
