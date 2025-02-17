package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Contract;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.ContractType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Ticket;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.ContractRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.TicketRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ContractRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ParkingRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ContractService {
    @Inject
    private ContractRepository repo;

    @Inject
    private ParkingRepository parkingRepo;

    @Inject
    private PersonRepository personRepo;

    public Result<Void> createContract(ContractRequest request) {
        try{
            Contract contract = new Contract();
            ContractType contractType = repo.getContractType(request.getTypeId());
            contract.setContractType(contractType);
            contract.setActive(true);
            contract.setStartDate(request.getStartDate());
            contract.setFinishDate(request.getEndDate());
            ParkingSpace parkingSpace = parkingRepo.getParkingSpaceById(request.getParkingId());
            contract.setParkingSpace(parkingSpace);
            Vehicle vehicle = personRepo.getVehicle(request.getVehicleId());
            contract.setVehicle(vehicle);
            repo.addContract(contract);
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<Contract>> getAllContracts(int parkingSpaceId) {
        try{
            List<Contract> contracts = repo.getAllContracts(parkingSpaceId);
            return Result.success(contracts);
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> addTicket(TicketRequest request){
        try{
            Ticket ticket = new Ticket();
            ticket.setStartDate(request.getStartDate());
            ticket.setFinishDate(request.getEndDate());
            ticket.setParkingSpace(parkingRepo.getParkingSpaceById(request.getParkingId()));
            ticket.setVehicle(personRepo.getVehicle(request.getVehicleId()));
            ticket.setActive(true);
            repo.addTicket(ticket);
            return Result.ok();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> endTicket(int id){
        try{
            repo.endTicket(id);
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<Ticket>> getAllTickets(){
        try{
            List<Ticket> tickets = repo.getAllTickets();
            return Result.success(tickets);

        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }
}
