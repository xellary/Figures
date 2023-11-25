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
        pointOnBaseCircle = points.get(1);
        topCenter = points.get(2);

        if (baseCenter.equals(pointOnBaseCircle)) {
            return false;
        }

        double radiusSquared = Math.pow(pointOnBaseCircle.x - baseCenter.x, 2)
                + Math.pow(pointOnBaseCircle.y - baseCenter.y, 2)
                + Math.pow(pointOnBaseCircle.z - baseCenter.z, 2);
        if (radiusSquared <= 0) {
            return false;
        }
        double height = Math.abs(topCenter.z - baseCenter.z);
        return height > 0;
    }
    @Override
    public void areaCalculation() {
        double radius = Math.sqrt(Math.pow(pointOnBaseCircle.x - baseCenter.x, 2)
                + Math.pow(pointOnBaseCircle.y - baseCenter.y, 2)
                + Math.pow(pointOnBaseCircle.z - baseCenter.z, 2));

        double height = Math.sqrt(Math.pow(topCenter.x - baseCenter.x, 2)
                + Math.pow(topCenter.y - baseCenter.y, 2)
                + Math.pow(topCenter.z - baseCenter.z, 2));

        double surfaceArea = 2 * Math.PI * radius * (radius + height);

        printArea(surfaceArea);
    }
}
