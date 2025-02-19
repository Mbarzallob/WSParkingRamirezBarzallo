package ec.edu.ups.ppw.WSParkingRamirezBarzallo.view;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.Gender;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.person.VehicleType;
import ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.config.ConfigRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("configuration")
@RequestScoped
public class ConfigurationBean {

    @Inject
    private ConfigRepository configRepository;

    private Gender gender = new Gender();
    private VehicleType vehicleType = new VehicleType();

    private List<Gender> genderList = new ArrayList<>();
    private List<VehicleType> vehicleTypes = new ArrayList<>();

    @PostConstruct
    public void init() {
        genderList= configRepository.getAllGenders();
        vehicleTypes= configRepository.getAllVehicleTypes();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Gender> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<Gender> genderList) {
        this.genderList = genderList;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public String guardarGender(){
        try{

            configRepository.addGender(gender);
            return "configList?faces-redirect=true";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String guardarVehicleType(){
        try{

            configRepository.addVehicleType(vehicleType);
            return "configList?faces-redirect=true";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
