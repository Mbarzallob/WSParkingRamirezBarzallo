package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpaceType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.ParkingSpaceTypeRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.BlockRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ParkingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ParkingService {
    @Inject
    private ParkingRepository parkingRepository;

    @Inject
    private BlockRepository blockRepository;
    public Result<List<ParkingSpace>> getParkingSpacesByBlock(int blockId) {
        try{
            return Result.success(parkingRepository.getParkingSpacesByBlock(blockId));
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<ParkingSpaceType>> getParkingSpaceTypes() {
        try{
            return Result.success(parkingRepository.getParkingSpaceTypes());
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
}
