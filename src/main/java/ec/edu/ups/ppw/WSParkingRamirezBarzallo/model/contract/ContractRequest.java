package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract;

import java.util.Date;

public class ContractRequest {
    private Date startDate;
    private Date endDate;
    private int parkingId;
    private char typeId;
    private int vehicleId;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
