package edu.chl.hajo.td.model.creeps;

import edu.chl.hajo.td.model.Path;
import edu.chl.hajo.td.util.Point2D;
import edu.chl.hajo.td.util.Vector2D;


public class Minions extends AbstractCreep {

    private double speed = 2;
    private int maxHp = 55;
    private int killPoints = 2;
    private int damage = 2;



    public Minions(Path path, Point2D startPos, Vector2D startDir) {
        super(startPos, startDir, path,2,55,2,2);
    }

    public Minions(Path path) {
        super(path,2,55,2,2);
    }

}