package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Contract;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.ContractType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Ticket;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
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

    public void addTicket(Ticket ticket) {
        em.persist(ticket);
    }

    @Transactional
    public void endTicket(int id) {
        Ticket ticket = em.find(Ticket.class, id);
        if (ticket == null) {
            throw new IllegalArgumentException("El ticket con ID " + id + " no existe.");
        }
        ticket.setFinishDate(LocalDateTime.now());
        ticket.setActive(false);
        em.merge(ticket);
    }

    public List<Ticket> getAllTickets(){
        TypedQuery<Ticket> q = em.createQuery("SELECT c FROM Ticket c where c.active = true ", Ticket.class);
        return q.getResultList();
    }

    public List<Ticket> getTickets(int parkingSpaceId){
        String query = "SELECT c FROM Ticket c where c.parkingSpace.id = :parkingSpaceId";
        TypedQuery<Ticket> q = em.createQuery(query, Ticket.class).setParameter("parkingSpaceId", parkingSpaceId);
        return q.getResultList();
    }

    public List<Contract> getContracts(){
        TypedQuery<Contract> q = em.createQuery("SELECT c FROM Contract c", Contract.class);
        return q.getResultList();
    }

    public List<Ticket> getTickets(){
        TypedQuery<Ticket> q = em.createQuery("SELECT c FROM Ticket c", Ticket.class);
        return q.getResultList();
    }

    public List<ContractType> getTypes(){
        TypedQuery<ContractType> q = em.createQuery("SELECT c FROM ContractType c", ContractType.class);
        return q.getResultList();
    }



}
