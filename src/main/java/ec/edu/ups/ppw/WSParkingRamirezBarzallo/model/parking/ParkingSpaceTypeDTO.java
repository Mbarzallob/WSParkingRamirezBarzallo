package ec.edu.ups.ppw.WSParkingRamirezBarzallo.model.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpace;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.ParkingSpaceType;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpaceTypeDTO {

    private int id;

    private int vehicleTypeId;
    private double priceHour;
    private double priceDay;
    private double priceWeek;
    private double priceMonth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
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

    public static ParkingSpaceTypeDTO getDTO(ParkingSpaceType parkingSpaceType) {
        ParkingSpaceTypeDTO parkingSpaceTypeDTO = new ParkingSpaceTypeDTO();
        parkingSpaceTypeDTO.setId(parkingSpaceType.getId());
        parkingSpaceTypeDTO.setVehicleTypeId(parkingSpaceType.getVehicleType().getId());
        parkingSpaceTypeDTO.setPriceHour(parkingSpaceType.getPriceHour());
        parkingSpaceTypeDTO.setPriceDay(parkingSpaceType.getPriceDay());
        parkingSpaceTypeDTO.setPriceWeek(parkingSpaceType.getPriceWeek());
        parkingSpaceTypeDTO.setPriceMonth(parkingSpaceType.getPriceMonth());
        return parkingSpaceTypeDTO;
    }

    public static List<ParkingSpaceTypeDTO> getDTOList(List<ParkingSpaceType> parkingSpaceTypes) {
        List<ParkingSpaceTypeDTO> parkingSpaceTypeDTOList = new ArrayList<>();
        for (ParkingSpaceType parkingSpaceType : parkingSpaceTypes) {
            parkingSpaceTypeDTOList.add(getDTO(parkingSpaceType));
        }
        return parkingSpaceTypeDTOList;
    }
}
