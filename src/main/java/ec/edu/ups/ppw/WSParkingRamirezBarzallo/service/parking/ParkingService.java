package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Contract;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract.Ticket;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpaceType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.VehicleType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.FilterParkingSpaces;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceTypeDTO;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceTypeRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.BlockRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ContractRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ParkingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ApplicationScoped
public class ParkingService {
    @Inject
    private ParkingRepository parkingRepository;

    @Inject
    private ContractRepository contractRepository;

    @Inject
    private BlockRepository blockRepository;
    public Result<List<ParkingSpace>> getParkingSpacesByBlock(int blockId, FilterParkingSpaces filter) {
        try {
            List<ParkingSpace> parkingSpaces = new ArrayList<>();
            if(blockId==-1){
                parkingSpaces = parkingRepository.getParkingSpaces();
            }else{
                parkingSpaces = parkingRepository.getParkingSpacesByBlock(blockId);
            }
            Iterator<ParkingSpace> iterator = parkingSpaces.iterator(); // Usamos Iterator para poder eliminar
            System.out.println(filter.toString());
            while (iterator.hasNext()) {
                ParkingSpace park = iterator.next();
                List<Contract> contracts = contractRepository.getAllContracts(park.getId());

                for (Contract contract : contracts) {
                    if (contract.isActive()) {
                        if (filter.getStartDate() != null && filter.getStartDate().isAfter(contract.getStartDate())) {
                            iterator.remove(); // Elimina el parking space si está ocupado en la fecha
                            break; // No es necesario seguir revisando contratos
                        }

                        if (filter.getEndDate() != null && filter.getEndDate().isBefore(contract.getFinishDate())) {
                            iterator.remove();
                            break;
                        }


                    }
                }


                if(filter.getVehicleType()!=null&&filter.getVehicleType()!=0 && filter.getVehicleType() != park.getParkingSpaceType().getVehicleType().getId()){
                    iterator.remove();
                    break;
                }
            }
            return Result.success(parkingSpaces);
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<ParkingSpace> getParkingSpaceById(int parkingSpaceId) {
        try{
            return Result.success(parkingRepository.getParkingSpaceById(parkingSpaceId));
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }
    public Result<List<ParkingSpace>> getParkingSpaces(){
        try{
            return Result.success(parkingRepository.getParkingSpaces());
        }
        catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }


    public Result<List<ParkingSpaceTypeDTO>> getParkingSpaceTypes() {
        try{
            return Result.success(ParkingSpaceTypeDTO.getDTOList(parkingRepository.getParkingSpaceTypes()));
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> addParkingSpace(ParkingSpaceRequest parkingSpaceRequest) {
        try{
            Block block = blockRepository.getBlock(parkingSpaceRequest.getBlockId());
            ParkingSpaceType spaceType = parkingRepository.getParkingSpaceTypeById(parkingSpaceRequest.getTypeId());
            ParkingSpace parkingSpace = new ParkingSpace();
            parkingSpace.setOccupied(false);
            parkingSpace.setParkingSpaceType(spaceType);
            parkingSpace.setBlock(block);
            parkingRepository.addParkingSpace(parkingSpace);
            return Result.ok();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> updateParkingSpaceType(ParkingSpaceTypeRequest parkingSpaceRequest, int typeId) {
        try {
            parkingRepository.updateParkingSpaceType(typeId, parkingSpaceRequest);
            return Result.ok();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> addParkingSpaceType(ParkingSpaceTypeRequest request) {
        try{
            ParkingSpaceType parkingSpaceType = new ParkingSpaceType();
            parkingSpaceType.setVehicleType(parkingRepository.getVehicleTypeById(request.getVehicleType()));
            parkingSpaceType.setPriceHour(request.getHourPrice());
            parkingSpaceType.setPriceWeek(request.getWeekPrice());
            parkingSpaceType.setPriceMonth(request.getMonthPrice());
            parkingSpaceType.setPriceDay(request.getDayPrice());
            parkingRepository.addParkingSpaceType(parkingSpaceType);
            return Result.ok();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }

    }

    public Result<Void> deleteParkingSpaceType(int parkingSpaceTypeId) {
        try{
            parkingRepository.deleteParkingSpaceType(parkingSpaceTypeId);
            return Result.ok();
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<VehicleType>> getVehicleTypes() {
        try{
            return Result.success(parkingRepository.getVehicleTypes());
        }catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }
}
