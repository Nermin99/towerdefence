package edu.chl.hajo.td.model;

import edu.chl.hajo.td.event.EventBus;
import edu.chl.hajo.td.event.ModelEvent;
import edu.chl.hajo.td.model.creeps.Creep;
import edu.chl.hajo.td.util.Point2D;
import lombok.Getter;
import edu.chl.hajo.td.model.towers.*;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*

    Class representing the full Game

    - GUI will call methods on this class (only)
    - GUI need some getters to display the model (parts of)

 */
public class TowerDefence {

    // Global constants
    public static final int TILE_SIZE = 32;  // 32x32 pixels
    public static final int GAME_SIZE = 20;  // 20x20 tiles
    public static final double GAME_HEIGHT = TILE_SIZE * GAME_SIZE; // 640
    public static final double GAME_WIDTH = GAME_HEIGHT;

    public static final long ONE_SEC = 1_000_000_000;   // Convenient
    public static final long TENTH_SEC = 100_000_000;

    @Getter
    private int points = 0;
    @Getter
    private int damage = 0;

    @Getter
    private final TDMap map;

    @Getter
    private List<Wave> waves;

    @Getter
    @Setter
    private int currentWave = 0;

    @Getter
    private List<AbstractTower> towers = new ArrayList<>();

    public TowerDefence(TDMap map, List<Wave> waves) {
        this.map = map;
        this.waves = waves;
    }

    // Update the model
    public void update(long now) {
        // TODO
        waves.get(currentWave).move();
        waves.get(currentWave).spawn(now);

        for (AbstractTower t : towers) {
            t.shootCreeps(waves.get(currentWave).getCreepList(), now);
        }

        points += waves.get(currentWave).getPoints();
        damage += waves.get(currentWave).getDamage();

        EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.CREEP_KILLED, Integer.toString(points)));
        EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.CREEP_FINISHED, Integer.toString(damage)));


        if (waves.get(currentWave).getCreepList().size() == 0 && waves.get(currentWave).getNCreeps() == 0) {
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.LEVEL_OVER));
        }
    }


    // TODO
    public void addTower(AbstractTower tower) {
        if (!getTile(tower.getPos().getX(), tower.getPos().getY()).isOccupied()) {
            getTile(tower.getPos().getX(), tower.getPos().getY()).setOccupied(true);
            towers.add(tower);
        }

    }


    // ------------ Conversions for GUI ------------------

    public TDTile getTile(double x, double y) {
        return map.getTileFor(x, y);
    }

    public Point2D getPosForTile(TDTile t) {
        return map.getPosFor(t);
    }

    // TODO


}
