package ec.edu.ups.ppw.WSParkingRamirezBarzallo.repository.parking;

import ec.edu.ups.ppw.WSParkingRamirezBarzallo.database.parking.Block;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class BlockRepository {

    @PersistenceContext
    private EntityManager em;

    public void addBlock(Block block) {
        em.persist(block);
    }

    public List<Block> getBlocks() {
        String query = "SELECT b FROM Block b";
        return em.createQuery(query, Block.class).getResultList();
    }

    public Block getBlock(int id) {
        return em.find(Block.class, id);
    }

    public void removeBlock(Block block) {
        em.remove(em.merge(block));
    }
}
