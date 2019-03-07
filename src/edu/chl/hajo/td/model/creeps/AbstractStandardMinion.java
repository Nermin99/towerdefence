package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;

public abstract class AbstractStandardMinion extends AbstractCreep {
    public AbstractStandardMinion(Path path, Point2D startPos, Vector2D startDir, double speed, int maxHp, int killPoints, int damage) {
        super(startPos, startDir, path, speed,maxHp,killPoints,damage);
    }

    public AbstractStandardMinion(Path path, double speed, int maxHp, int killPoints, int damage) {
        super(path, speed,maxHp,killPoints,damage);
    }


    public Minions copyOf() {
        try {
            return (Minions) super.clone();
        } catch (CloneNotSupportedException e) {
            return (Minions) this;
        }
    }
}
