package edu.chl.hajo.td.model.towers;

import edu.chl.hajo.td.util.Point2D;
import static edu.chl.hajo.td.model.TowerDefence.TENTH_SEC;

public class BasicImpactTower extends AbstractImpactTower {

    public BasicImpactTower(Point2D pos) {
        super(pos,32,32,80,TENTH_SEC,1);
    }

}
