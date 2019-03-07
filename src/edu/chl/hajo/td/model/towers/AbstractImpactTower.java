package edu.chl.hajo.td.model.towers;

import edu.chl.hajo.td.model.creeps.AbstractCreep;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;

import java.util.List;

import static edu.chl.hajo.td.model.TowerDefence.TENTH_SEC;

public abstract class  AbstractImpactTower extends AbstractTower {

    public AbstractImpactTower(Point2D pos, int height, int width, double range, long cooldown, int firePower) {
        super(pos, height, width, range,cooldown,firePower);
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


