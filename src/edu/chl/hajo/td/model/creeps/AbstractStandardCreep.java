package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;

public abstract class AbstractStandardCreep extends AbstractCreep {

    public AbstractStandardCreep(Path path, Point2D startPos, Vector2D startDir, double speed, int maxHp, int killPoints, int damage) {
        super(startPos, startDir, path,speed,maxHp,killPoints,damage);
    }

    public AbstractStandardCreep(Path path, double speed, int maxHp, int killPoints, int damage) {
        super (path,speed,maxHp,killPoints,damage);
    }

    public Creep copyOf() {
        try {
            return (Creep) super.clone();
        } catch (CloneNotSupportedException e) {
            return (Creep) this;
        }
    }
}
