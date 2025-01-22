package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;

import jakarta.validation.constraints.NotBlank;

public class BlockRequest {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
