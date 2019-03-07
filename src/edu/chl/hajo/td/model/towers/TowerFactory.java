package edu.chl.hajo.td.model.towers;

import edu.chl.hajo.td.util.Point2D;


/*
     A Factory for towers. Used by controls
 */
public final class TowerFactory {

    public enum Type {
        NONE,
        BASIC_GUN_TOWER,
        BASIC_IMPACT_TOWER,// TODO Possibly rename
        ADVANCED_GUN_TOWER,
        ADVANCED_IMPACT_TOWER
    }


    public static AbstractTower getTower(Type type, Point2D pos) {
        switch (type) {
            case BASIC_GUN_TOWER:
                return new BasicGunTower(pos);   // TODO
            case BASIC_IMPACT_TOWER:
                return new BasicImpactTower(pos);
            case ADVANCED_GUN_TOWER:
                return new AdvancedGunTower(pos);
            case ADVANCED_IMPACT_TOWER:
                return new AdvancedImpactTower(pos);
            default:
                throw new IllegalArgumentException("No such tower " + type);
        }
    }

    private TowerFactory() {
    }

}
