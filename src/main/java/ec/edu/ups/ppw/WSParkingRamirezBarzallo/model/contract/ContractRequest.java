package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract;

import java.time.LocalDate;

public class ContractRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private int parkingId;
    private char typeId;
    private int vehicleId;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public char getTypeId() {
        return typeId;
    }

    public void setTypeId(char typeId) {
        this.typeId = typeId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
