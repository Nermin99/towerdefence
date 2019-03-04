package edu.chl.hajo.td.model;

import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractMovable {
    @Setter
    @Getter
    protected Point2D pos;    // Center position

    @Getter
    @Setter
    protected Vector2D dir;  // Normalized direction for moving

    public AbstractMovable(Point2D pos, Vector2D dir) {
        this.pos = pos;
        this.dir = dir;
    }

    public abstract void move();
}
