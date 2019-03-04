package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;
import lombok.Getter;
import lombok.Setter;

/*
 *     A basic creep (something that follows a path)
 *     - Follows exactly one path
 *     - Will damage you if arriving at path end
 *     - May be killed by some tower placed by you
 */
public class Creep extends AbstractCreep {

    public Creep(Path path, Point2D startPos, Vector2D startDir) {
        super(startPos, startDir, path);
    }

    public Creep(Path path) {
        super (path);
    }


}
