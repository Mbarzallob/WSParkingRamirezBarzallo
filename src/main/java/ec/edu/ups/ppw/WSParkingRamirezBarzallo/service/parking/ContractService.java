package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Contract;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.ContractType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Ticket;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.ContractRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.FilterContract;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.FilterTicket;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract.TicketRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ContractRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ParkingRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.person.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
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

    public Result<Integer> addTicket(TicketRequest request){
        try{
            Ticket ticket = new Ticket();
            ticket.setStartDate(request.getStartDate());
            ticket.setFinishDate(request.getEndDate());
            ticket.setParkingSpace(parkingRepo.getParkingSpaceById(request.getParkingId()));
            ticket.setVehicle(personRepo.getVehicle(request.getVehicleId()));
            ticket.setActive(true);
            repo.addTicket(ticket);
            System.out.println("...................................");
            System.out.println(ticket.getId());
            System.out.println("----------------------------");
            return Result.success(ticket.getId());
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

    public Result<List<Ticket>> getReportTickets(FilterTicket filter){
        try{
            var tickets = filterTickets(filter);
            return Result.success(tickets);
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }


    public List<Ticket> filterTickets(FilterTicket filter) {
        List<Ticket> tickets = repo.getTickets();
        List<Ticket> filteredTickets = new ArrayList<>();

        for (Ticket ticket : tickets) {
            boolean matches = true;

            if (filter.getActive() != null && ticket.isActive() != filter.getActive()) {
                matches = false;
            }

            if (filter.getParkingSpace() != null && (ticket.getParkingSpace() == null || ticket.getParkingSpace().getId() != filter.getParkingSpace())) {
                matches = false;
            }

            if (filter.getVehicle() != null && (ticket.getVehicle() == null || ticket.getVehicle().getId() != filter.getVehicle())) {
                matches = false;
            }

            if (filter.getStartDate() != null && (ticket.getStartDate() == null || !ticket.getStartDate().isEqual(filter.getStartDate()))) {
                matches = false;
            }

            if (filter.getFinishDate() != null && (ticket.getFinishDate() == null || !ticket.getFinishDate().isEqual(filter.getFinishDate()))) {
                matches = false;
            }

            if (matches) {
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    public Result<List<Contract>> getReportContracts(FilterContract filter){
        try{
            var tickets = filterContracts(filter);
            return Result.success(tickets);
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }
    public List<Contract> filterContracts(FilterContract filter) {
        List<Contract> contracts = repo.getContracts();
        List<Contract> filteredContracts = new ArrayList<>();

        for (Contract contract : contracts) {
            boolean matches = true;

            if (filter.getActive() != null && contract.isActive() != filter.getActive()) {
                matches = false;
            }

            if (filter.getParkingSpace() != null && (contract.getParkingSpace() == null || contract.getParkingSpace().getId() != filter.getParkingSpace())) {
                matches = false;
            }

            if (filter.getVehicle() != null && (contract.getVehicle() == null || contract.getVehicle().getId() != filter.getVehicle())) {
                matches = false;
            }

            if (filter.getStartDate() != null && (contract.getStartDate() == null || !contract.getStartDate().isEqual(filter.getStartDate()))) {
                matches = false;
            }

            if (filter.getFinishDate() != null && (contract.getFinishDate() == null || !contract.getFinishDate().isEqual(filter.getFinishDate()))) {
                matches = false;
            }

            if (filter.getContractType() != null &&
                    (contract.getContractType() == null ||
                            !filter.getContractType().equals(contract.getContractType().getId()))) {
                matches = false;
            }

            if (matches) {
                filteredContracts.add(contract);
            }
        }
        return filteredContracts;
    }


    public Result<List<ContractType>> getTypes(){
        try{
            List<ContractType> types = repo.getTypes();
            return Result.success(types);
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> CancelContract(int id){
        try{
            repo.cancelContract(id);
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }
}
