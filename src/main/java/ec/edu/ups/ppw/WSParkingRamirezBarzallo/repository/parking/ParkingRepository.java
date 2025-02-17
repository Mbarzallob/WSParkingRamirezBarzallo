package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpaceType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Person;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.VehicleType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceTypeRequest;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ParkingRepository {
    @PersistenceContext
    private EntityManager em;

    public List<ParkingSpace> getParkingSpacesByBlock(int blockId) {
        String query = "SELECT p from ParkingSpace p where p.block.id = :blockId";
        return em.createQuery(query, ParkingSpace.class).setParameter("blockId", blockId).getResultList();
    }

    public List<ParkingSpace> getParkingSpaces() {
        String query = "SELECT p from ParkingSpace p";
        return em.createQuery(query, ParkingSpace.class).getResultList();
    }

    public List<ParkingSpaceType> getParkingSpaceTypes() {
        String query = "SELECT p from ParkingSpaceType p";
        return em.createQuery(query, ParkingSpaceType.class).getResultList();
    }

    public ParkingSpace getParkingSpaceById(int id) {
        return em.find(ParkingSpace.class, id);
    }
    public ParkingSpaceType getParkingSpaceTypeById(int id) {
        return em.find(ParkingSpaceType.class, id);
    }
    public void addParkingSpace(ParkingSpace parkingSpace) {
        em.persist(parkingSpace);
    }

    public void updateParkingSpaceType(int typeId, ParkingSpaceTypeRequest request){
        ParkingSpaceType parkingSpaceType = em.find(ParkingSpaceType.class, typeId);
        if(parkingSpaceType == null){
            throw new IllegalArgumentException("No existe un tipo de parking");
        }
        parkingSpaceType.setPriceDay(request.getDayPrice());
        parkingSpaceType.setPriceMonth(request.getMonthPrice());
        parkingSpaceType.setPriceHour(request.getHourPrice());
        parkingSpaceType.setPriceWeek(request.getWeekPrice());
        parkingSpaceType.setVehicleType(getVehicleTypeById(request.getVehicleType()));
        em.merge(parkingSpaceType);
    }

    public void addParkingSpaceType(ParkingSpaceType parkingSpaceType) {
        em.persist(parkingSpaceType);
    }

    public void deleteParkingSpaceType(int id) {
        ParkingSpaceType parkingSpace = em.find(ParkingSpaceType.class, id);
        em.remove(parkingSpace);
    }

    public List<VehicleType> getVehicleTypes() {
        String query = "SELECT p from VehicleType p";
        return em.createQuery(query, VehicleType.class).getResultList();
    }
    public VehicleType getVehicleTypeById(int id) {
        return em.find(VehicleType.class, id);
    }

    public List<String> getEmailsOfPersonsWithActiveTickets() {
        String jpql = " SELECT DISTINCT p.email FROM Person p\n" +
                "        JOIN p.vehicles v\n" +
                "        JOIN Ticket t ON t.vehicle = v\n" +
                "        WHERE t.active = true";

        return em.createQuery(jpql, String.class).getResultList();
    }

    public List<String> getAllEmails(){
        String jpql = "SELECT DISTINCT p.email FROM Person p";
        return em.createQuery(jpql, String.class).getResultList();
    }

}
