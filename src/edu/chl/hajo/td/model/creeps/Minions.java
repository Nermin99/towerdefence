package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;


public class Minions extends AbstractCreep {
    public Minions(Path path, Point2D startPos, Vector2D startDir) {
        super(startPos, startDir, path);
    }

    public Minions(Path path) {
        super(path);
    }


    public Minions copyOf() {
        try {
            return (Minions) super.clone();
        } catch (CloneNotSupportedException e) {
            return (Minions) this;
        }
    }
}