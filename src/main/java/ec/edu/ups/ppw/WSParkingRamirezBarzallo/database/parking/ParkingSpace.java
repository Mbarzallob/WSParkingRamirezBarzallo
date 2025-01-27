package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking;

import jakarta.persistence.*;

@Entity
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private boolean occupied;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parkink_space_type_id", nullable = false)
    private ParkingSpaceType parkingSpaceType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public ParkingSpaceType getParkingSpaceType() {
        return parkingSpaceType;
    }

    public void setParkingSpaceType(ParkingSpaceType parkingSpaceType) {
        this.parkingSpaceType = parkingSpaceType;
    }
}
