package ec.edu.ups.ppw.WSParkingRamirezBarzallo.view;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockDTO;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking.BlockService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("blocks")
@RequestScoped
public class BlockBean {
    @Inject
    private BlockService blockService;

    private List<BlockDTO> blocks;
    private BlockRequest blockR = new BlockRequest();

    @PostConstruct
    public void init(){
        blocks = blockService.getBlocks().getData();
    }

    public List<BlockDTO> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BlockDTO> blocks) {
        this.blocks = blocks;
    }

    public BlockRequest getBlock() {
        return blockR;
    }

    public void setBlock(BlockRequest block) {
        this.blockR = block;
    }
    public String guardar(){
        try{

            blockService.addBlock(blockR);
            return "blockList?faces-redirect=true";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
