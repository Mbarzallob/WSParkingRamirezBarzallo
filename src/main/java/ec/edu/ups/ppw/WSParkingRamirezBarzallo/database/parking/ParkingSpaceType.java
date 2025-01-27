package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Role;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.VehicleType;
import jakarta.persistence.*;

@Entity
@Table(name = "parking_space_types")
public class ParkingSpaceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_type_id",nullable = false)
    private VehicleType vehicleType;
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}