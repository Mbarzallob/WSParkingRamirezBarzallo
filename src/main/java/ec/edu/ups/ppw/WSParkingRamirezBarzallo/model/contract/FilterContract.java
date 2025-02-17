package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.contract;

import java.time.LocalDate;

public class FilterContract {
    private Boolean active;
    private Integer parkingSpace;
    private Integer vehicle;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Character contractType;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(Integer parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Integer getVehicle() {
        return vehicle;
    }

    public void setVehicle(Integer vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Character getContractType() {
        return contractType;
    }

    public void setContractType(Character contractType) {
        this.contractType = contractType;
    }
}
