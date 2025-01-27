package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract_types")
public class ContractType {
    @Id
    private char id;

    @Column(nullable = false)
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
