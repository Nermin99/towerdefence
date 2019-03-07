package edu.chl.hajo.td.model.towers;

import edu.chl.hajo.td.model.AbstractMovable;
import edu.chl.hajo.td.model.creeps.AbstractCreep;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

import static edu.chl.hajo.td.model.TowerDefence.ONE_SEC;

public abstract class AbstractTower {
    @Setter
    @Getter
    protected Point2D pos;    // Center position

    @Getter
    protected double width; // Upper right corner: x - width / 2
    @Getter
    protected double height;  // Upper right corner: y - height / 2

    @Getter
    protected double range;    // Max distance to fire
    @Getter
    protected long coolDown;  // Time before next shoot
    @Getter
    protected int firePower;

    protected long lastShot = 0;

    protected static final Vector2D INIT_DIR = new Vector2D(-1, 0);
    @Getter
    protected Vector2D dir = INIT_DIR;

    public AbstractTower(Point2D pos, double height, double width, double range, long coolDown, int firePower) {
        this.pos = pos;
        this.height = height;
        this.width = width;
        this.range = range;
        this.coolDown = coolDown;
        this.firePower = firePower;
    }

    public abstract void shootCreeps(List<AbstractCreep> creepList, long now);

}