package ec.edu.ups.ppw.WSParkingRamirezBarzallo.view;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockDTO;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking.BlockRequest;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.BlockRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking.ParkingRepository;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.service.parking.BlockService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("blockParkingBean")
@RequestScoped
public class BlockBean {

    @Inject
    private BlockRepository blockRepository;

    @Inject
    private ParkingRepository parkingRepository;

    private Block block = new Block();
    private List<Block> blocks;
    private List<ParkingSpace> parkingSpaces;
    private int selectedBlockId;

    @PostConstruct
    public void init() {
        blocks = blockRepository.getBlocks();
    }

    // Obtener lista de bloques
    public List<Block> getBlocks() {
        return blocks;
    }

    // Obtener espacios de estacionamiento según el bloque seleccionado
    public void loadParkingSpaces() {
        if (selectedBlockId > 0) {
            parkingSpaces = parkingRepository.getParkingSpacesByBlock(selectedBlockId);
        }
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    // Guardar un nuevo bloque
    public String addBlock() {
        try {
            blockRepository.addBlock(block);
            blocks = blockRepository.getBlocks(); // Actualizar lista
            block = new Block(); // Limpiar el formulario
            return "blockList?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    // Setters y Getters
    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public int getSelectedBlockId() {
        return selectedBlockId;
    }

    public void setSelectedBlockId(int selectedBlockId) {
        this.selectedBlockId = selectedBlockId;
        loadParkingSpaces();
    }
}