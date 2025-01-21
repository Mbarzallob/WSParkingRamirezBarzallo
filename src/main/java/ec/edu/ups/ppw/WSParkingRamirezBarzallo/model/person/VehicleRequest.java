package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.person;

public class VehicleRequest {
    private String plate;
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
