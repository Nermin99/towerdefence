package edu.chl.hajo.td.model.towers;

import edu.chl.hajo.td.model.creeps.AbstractCreep;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;

import java.util.List;

import static edu.chl.hajo.td.model.TowerDefence.TENTH_SEC;

public abstract class AbstractGunTower extends AbstractTower {

    public AbstractGunTower(Point2D pos, int h, int w, int range, long cooldown, int firepower) {
        super(pos,h,w,range,cooldown,firepower);
    }


    @Override
    public void shootCreeps(List<AbstractCreep> creepList, long now) {
        for (AbstractCreep c : creepList) {
            lastShot = lastShot == 0 ? now : lastShot;

            long delta = now - lastShot;

            if (this.pos.distance(c.getPos()) <= range && delta >= coolDown) {
                dir = new Vector2D(getPos(), c.getPos());
                c.setHp(c.getHp() - firePower);
                lastShot = now;
            }
        }
    }
}
