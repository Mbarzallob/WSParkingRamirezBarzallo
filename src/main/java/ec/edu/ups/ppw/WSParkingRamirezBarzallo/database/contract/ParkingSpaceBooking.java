package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Vehicle;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "parking_space_booking")
public class ParkingSpaceBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name="finish_date", nullable = false)
    private LocalDate finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_type_id", nullable = false)
    private ContractType contractType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
