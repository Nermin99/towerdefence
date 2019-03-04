package edu.chl.hajo.td.model.towers;

import edu.chl.hajo.td.util.Point2D;


/*
     A Factory for towers. Used by controls
 */
public final class TowerFactory {

    public enum Type {
        NONE,
        BASIC_GUN_TOWER,
        BASIC_IMPACT_TOWER  // TODO Possibly rename
    }


    public static AbstractTower getTower(Type type, Point2D pos) {
        switch (type) {
            case BASIC_GUN_TOWER:
                return null;   // TODO
            default:
                throw new IllegalArgumentException("No such tower " + type);
        }
    }

    private TowerFactory() {
    }

}
