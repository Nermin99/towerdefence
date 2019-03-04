package edu.chl.hajo.td.model;


import edu.chl.hajo.td.util.Point2D;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *   A path for creeps (waves) to follow
 */
public class Path {
    /*
    @Getter
    private final int id;
    */
    @Getter
    private final List<Point2D> points = new ArrayList<>();  // TODO

    // TODO
    private final Point2D startPoint;

    public Path(int start, List<String> strPts, int tile_size) {
        for (int i = 0; i < strPts.size(); i++) {
            String[] strPoint = strPts.get(i).split(",");
            double x = tile_size * Double.parseDouble(strPoint[0]);
            double y = tile_size * Double.parseDouble(strPoint[1]);

            this.points.add(new Point2D(x, y));
        }
        this.startPoint = this.points.get(start);
    }

    public List<Point2D> getPoints() {
        return points;
    }

    public Point2D get(int i) {
        return points.get(i);
    }

    public Point2D getStartPoint() {
        return startPoint;
    }
}
