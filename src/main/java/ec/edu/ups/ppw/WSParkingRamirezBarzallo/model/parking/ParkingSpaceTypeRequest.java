package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ParkingSpaceTypeRequest {
    @Positive(message = "El precio debe ser mayor a 0")
    private double hourPrice;
    @Positive(message = "El precio debe ser mayor a 0")
    private double dayPrice;
    @Positive(message = "El precio debe ser mayor a 0")
    private double weekPrice;
    @Positive(message = "El precio debe ser mayor a 0")
    private double monthPrice;

    private int vehicleType;

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public double getWeekPrice() {
        return weekPrice;
    }

    public void setWeekPrice(double weekPrice) {
        this.weekPrice = weekPrice;
    }

    public double getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(double monthPrice) {
        this.monthPrice = monthPrice;
    }
}
