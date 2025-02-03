package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;

import jakarta.validation.constraints.NotBlank;

public class ParkingSpaceRequest {
    @NotBlank(message = "Ingrese un bloque valido")
    private int blockId;
    @NotBlank(message = "Ingrese un tipo valido")
    private int typeId;

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
