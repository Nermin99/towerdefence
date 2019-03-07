package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;

public class Boss extends AbstractStandardBoss{

    private double speed = 1;
    private int maxHp = 300;
    private int killPoints = 5;
    private int damage = 5;


    public Boss(Path path, Point2D startPos, Vector2D startDir) {
        super(path,startPos, startDir, 1, 300, 5, 5);
    }

    public Boss(Path path) {
        super(path, 1, 300, 5, 5);
    }

}
