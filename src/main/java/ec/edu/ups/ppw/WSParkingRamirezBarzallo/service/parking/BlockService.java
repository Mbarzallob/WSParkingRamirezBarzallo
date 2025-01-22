package ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
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

    public Response addBlock(BlockRequest block) {
        try{
            Block newBlock = new Block();
            newBlock.setName(block.getName());
            blockRepository.addBlock(newBlock);
            return Response.ok().build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    public Response getBlocks() {
        try{
            List<Block> blocks = blockRepository.getBlocks();
            List<BlockDTO> blockDTOs = blocks.stream().map(BlockDTO::new).collect(Collectors.toList());

            return Response.ok().entity(blockDTOs).build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    public Response removeBlock(int blockId) {
        try{
            Block block = blockRepository.getBlock(blockId);
            if(block == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            blockRepository.removeBlock(block);
            return Response.ok().build();
        }catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
