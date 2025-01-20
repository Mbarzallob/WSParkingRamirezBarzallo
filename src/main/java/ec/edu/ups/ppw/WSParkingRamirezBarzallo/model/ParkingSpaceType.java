package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingSpaceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    @Column(name = "price_hour")
    private double priceHour;
    @Column(name = "price_day")
    private double priceDay;
    @Column(name = "price_week")
    private double priceWeek;
    @Column(name = "price_month")
    private double priceMonth;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPriceHour() {
        return priceHour;
    }
    public void setPriceHour(double priceHour) {
        this.priceHour = priceHour;
    }
    public double getPriceDay() {
        return priceDay;
    }
    public void setPriceDay(double priceDay) {
        this.priceDay = priceDay;
    }
    public double getPriceWeek() {
        return priceWeek;
    }
    public void setPriceWeek(double priceWeek) {
        this.priceWeek = priceWeek;
    }
    public double getPriceMonth() {
        return priceMonth;
    }
    public void setPriceMonth(double priceMonth) {
        this.priceMonth = priceMonth;
    }




}
