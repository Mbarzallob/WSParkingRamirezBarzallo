package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpaceType;
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
        em.merge(parkingSpaceType);
    }

    public List<VehicleType> getVehicleTypes() {
        String query = "SELECT p from VehicleType p";
        return em.createQuery(query, VehicleType.class).getResultList();
    }
}
