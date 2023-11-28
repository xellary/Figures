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
    public boolean figureValidation() {
        if (points.size() != AMOUNT_OF_POINTS_THREE) {
            return false;
        }
        baseCenter = points.get(0);
        topCenter = points.get(1);
        pointOnBaseCircle = points.get(2);

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
    public void areaCalculation() {
        double radius = calculateLength(pointOnBaseCircle, baseCenter);
        double height = calculateLength(topCenter, baseCenter);
        double surfaceArea = 2 * Math.PI * radius * (radius + height);
        printArea(surfaceArea);
    }
}
