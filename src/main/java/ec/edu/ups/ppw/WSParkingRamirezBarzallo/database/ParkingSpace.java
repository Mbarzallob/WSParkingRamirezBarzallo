package ec.edu.ups.ppw.WSParkingRamirezBarzallo.database;

import jakarta.persistence.*;

@Entity
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id")
    private Block block;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parkink_space_type_id")
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
}
