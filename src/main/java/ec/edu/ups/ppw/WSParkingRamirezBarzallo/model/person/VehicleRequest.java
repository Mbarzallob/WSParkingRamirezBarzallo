package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person;

import jakarta.validation.constraints.NotBlank;

public class VehicleRequest {
    @NotBlank(message = "Ingrese una placa valida")
    private String plate;
    @NotBlank(message = "Ingrese un modelo valido")
    private String model;
    private int type;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
