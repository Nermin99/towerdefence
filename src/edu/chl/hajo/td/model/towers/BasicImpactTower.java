package edu.chl.hajo.td.model.towers;
import edu.chl.hajo.td.model.creeps.AbstractCreep;
import edu.chl.hajo.td.model.creeps.Creep;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;

import java.util.*;

import static edu.chl.hajo.td.model.TowerDefence.ONE_SEC;
import static edu.chl.hajo.td.model.TowerDefence.TENTH_SEC;

public class BasicImpactTower extends AbstractTower {

    public BasicImpactTower(Point2D pos) {
        super(pos,32,32,80,TENTH_SEC,1);
    }

    @Override
    public void shootCreeps(List<AbstractCreep> creepList, long now) {
        lastShot = lastShot == 0 ? now : lastShot;

        long delta = now - lastShot;

        for (AbstractCreep c : creepList) {
            if (this.pos.distance(c.getPos()) <= range && delta >= coolDown) {
                dir = new Vector2D(getPos(), c.getPos());
                c.setHp(c.getHp() - firePower);
                lastShot = now;
            }
        }
    }
}
