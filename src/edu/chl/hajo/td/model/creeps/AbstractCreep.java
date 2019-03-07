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
    protected double speed;

    @Getter
    protected Path path;

    @Setter
    @Getter
    protected Point2D currentCheckPoint;

    @Getter
    @Setter
    protected int hp;  // Current health
    @Getter
    protected int maxHp;      // Needed for % display in GUI
    @Getter
    protected int killPoints;  // Points to player when killed
    @Getter
    protected int damage;      // Damage caused when arriving at (non existing) base of player

    public AbstractCreep(Point2D startPos, Vector2D startDir, Path path, double speed, int maxHp, int killPoints, int damage) {
        super(startPos, startDir);
        this.speed = speed;
        this.path = path;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.killPoints = killPoints;
        this.damage = damage;
        this.currentCheckPoint = path.getStartPoint();
    }

    public AbstractCreep(Path path, double speed, int maxHp, int killPoints, int damage) {
        this(path.getStartPoint(), new Vector2D(path.getStartPoint(), path.get(1)), path, speed, maxHp,killPoints,damage);

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

    public abstract AbstractCreep copyOf();


//    public Minions copyOf() {
//        try {
//            return (Minions) super.clone();
//        } catch (CloneNotSupportedException e) {
//            return (Minions) this;
//        }
//    }

}




