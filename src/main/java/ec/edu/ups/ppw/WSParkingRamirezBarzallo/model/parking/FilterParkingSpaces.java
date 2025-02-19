package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;


import java.time.LocalDate;

public class FilterParkingSpaces {
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer vehicleType;
    private Boolean forTicket;

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getForTicket() {
        return forTicket;
    }

    public void setForTicket(Boolean forTicket) {
        this.forTicket = forTicket;
    }

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

    @Override
    public String toString() {
        return "FilterParkingSpaces{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
