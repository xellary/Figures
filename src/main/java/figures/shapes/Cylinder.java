package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Cylinder extends Figure {
    private final ArrayList<Point> points;

    private Point baseCenter;

    private Point pointOnBaseCircle;

    private Point topCenter;

    public Cylinder(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() != AMOUNT_OF_POINTS_THREE) {
            return false;
        }

        getPoints();
        if (baseCenter.equals(pointOnBaseCircle)) {
            return false;
        }

        double radiusSquared = calculateLength(pointOnBaseCircle, baseCenter);
        if (radiusSquared <= 0) {
            return false;
        }
        double height = Math.abs(topCenter.getZ() - baseCenter.getZ());
        return height > 0;
    }
    @Override
    public double calculateArea() {
        getPoints();
        double radius = calculateLength(pointOnBaseCircle, baseCenter);
        double height = calculateLength(topCenter, baseCenter);
        return  2 * Math.PI * radius * (radius + height);
    }

    private void getPoints() {
        baseCenter = points.get(FIRST_POINT_INDEX);
        topCenter = points.get(SECOND_POINT_INDEX);
        pointOnBaseCircle = points.get(THIRD_POINT_INDEX);
    }
}
