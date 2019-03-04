package edu.chl.hajo.td.model.towers;

import edu.chl.hajo.td.model.AbstractMovable;
import edu.chl.hajo.td.model.creeps.Creep;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;
import lombok.Getter;
import lombok.Setter;

import static edu.chl.hajo.td.model.TowerDefence.ONE_SEC;
import static edu.chl.hajo.td.model.TowerDefence.TENTH_SEC;

/*
        Basic GunTower

 */
public class Tower extends AbstractTower {




    public Tower(Point2D pos) {
        super(pos,32,32,80,ONE_SEC/2,1);
    }


    @Override
    public void shootCreeps(Creep c, long now) {
        lastShot = lastShot == 0 ? now : lastShot;

        long delta = now - lastShot;

        if (this.pos.distance(c.getPos()) <= range && delta >= coolDown) {
            dir = new Vector2D(getPos(), c.getPos());
            c.setHp(c.getHp() - firePower);
            lastShot = now;
        }
    }


}



