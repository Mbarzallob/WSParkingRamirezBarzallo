package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ContractType {
    @Id
    private char id;

    private String name;

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
