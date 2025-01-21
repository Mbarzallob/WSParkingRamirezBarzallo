package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;

public class ParkingSpaceTypeRequest {
    private double hourPrice;
    private double dayPrice;
    private double weekPrice;
    private double monthPrice;

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
