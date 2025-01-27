package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.generic.Result;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockDTO;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.BlockRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BlockService {
    @Inject
    private BlockRepository blockRepository;

    public Result<Void> addBlock(BlockRequest block) {
        try{
            Block newBlock = new Block();
            newBlock.setName(block.getName());
            blockRepository.addBlock(newBlock);
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<List<BlockDTO>> getBlocks() {
        try{
            List<Block> blocks = blockRepository.getBlocks();
            List<BlockDTO> blockDTOs = blocks.stream().map(BlockDTO::new).collect(Collectors.toList());

            return Result.success(blockDTOs);
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }

    public Result<Void> removeBlock(int blockId) {
        try{
            Block block = blockRepository.getBlock(blockId);
            if(block == null){
                return Result.failure("Bloque no encontrado");
            }
            blockRepository.removeBlock(block);
            return Result.ok();
        }catch (Exception e){
            return Result.failure(e.getMessage());
        }
    }
}
