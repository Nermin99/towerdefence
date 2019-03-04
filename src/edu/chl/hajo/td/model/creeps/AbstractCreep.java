package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.AbstractMovable;
import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractCreep extends AbstractMovable implements Cloneable {

    @Getter
    protected double width = 20; // Upper right corner: x - width / 2
    @Getter
    protected double height = 20;

    @Setter
    @Getter
    protected double speed = 1;

    @Getter
    protected Path path;

    @Setter
    @Getter
    protected Point2D currentCheckPoint;

    @Getter
    @Setter
    protected int hp;  // Current health
    @Getter
    protected int maxHp = 2;      // Needed for % display in GUI
    @Getter
    protected int killPoints = 1;  // Points to player when killed
    @Getter
    protected int damage = 1;      // Damage caused when arriving at (non existing) base of player

    public AbstractCreep(Point2D startPos, Vector2D startDir, Path path) {
        super(startPos, startDir);
        this.path = path;
        this.hp = maxHp;
        this.currentCheckPoint = path.getStartPoint();
    }

    public AbstractCreep(Path path) {
        this(path.getStartPoint(), new Vector2D(path.getStartPoint(), path.get(1)), path);
    }

    @Override
    public void move(){
        Point2D nextCheckPoint = getNextCheckPoint(currentCheckPoint);

        if (pos.epsilonEquals(nextCheckPoint, speed + 0.1)) {
            currentCheckPoint = nextCheckPoint;
            dir = new Vector2D(currentCheckPoint, getNextCheckPoint(currentCheckPoint));
        }
        double x = pos.getX() + dir.getX() * speed;
        double y = pos.getY() + dir.getY() * speed;

        pos = new Point2D(x, y); // move on
    }

    public Point2D getNextCheckPoint(Point2D pos) {
        int idx = this.path.getPoints().indexOf(pos);

        if (idx + 1 == this.path.getPoints().size()) {
            return this.currentCheckPoint; // TODO good stop?
        }
        return this.path.getPoints().get(idx + 1);
    }

//    @Override
//    public AbstractCreep clone() throws CloneNotSupportedException {
//        return (AbstractCreep) super.clone();
//    }

    public Creep copyOf() {
        try {
            return (Creep) super.clone();
        } catch (CloneNotSupportedException e) {
            return (Creep) this;
        }
    }

}




