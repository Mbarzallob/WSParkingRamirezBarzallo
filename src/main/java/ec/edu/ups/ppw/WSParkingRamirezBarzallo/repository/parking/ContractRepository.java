package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Contract;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.ContractType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class ContractRepository {
    @PersistenceContext
    private EntityManager em;

    public void addContract(Contract contract) {
        em.persist(contract);
    }
    public ContractType getContractType(char id){
        return em.find(ContractType.class, id);
    }

    public List<Contract> getAllContracts(int parkingSpaceId){
        String query = "SELECT c FROM Contract c where c.parkingSpace.id = :parkingSpaceId";
        TypedQuery<Contract> q = em.createQuery(query, Contract.class).setParameter("parkingSpaceId", parkingSpaceId);
        return q.getResultList();
    }
}
