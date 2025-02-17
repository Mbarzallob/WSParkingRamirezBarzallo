package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;


import java.time.LocalDate;

public class FilterParkingSpaces {
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer vehicleType;

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

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }
}
