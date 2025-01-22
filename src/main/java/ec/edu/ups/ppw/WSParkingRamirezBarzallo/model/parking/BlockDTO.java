package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;

public class BlockDTO {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public BlockDTO(Block block) {
        this.id = block.getId();
        this.name = block.getName();
    }
}
