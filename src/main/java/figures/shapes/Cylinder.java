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

        double radiusSquared = Math.pow(pointOnBaseCircle.getX() - baseCenter.getX(), 2)
                + Math.pow(pointOnBaseCircle.getY() - baseCenter.getY(), 2)
                + Math.pow(pointOnBaseCircle.getZ() - baseCenter.getZ(), 2);
        if (radiusSquared <= 0) {
            return false;
        }
        double height = Math.abs(topCenter.getZ() - baseCenter.getZ());
        return height > 0;
    }
    @Override
    public void areaCalculation() {
        double radius = Math.sqrt(Math.pow(pointOnBaseCircle.getX() - baseCenter.getX(), 2)
                + Math.pow(pointOnBaseCircle.getY() - baseCenter.getY(), 2)
                + Math.pow(pointOnBaseCircle.getZ() - baseCenter.getZ(), 2));

        double height = Math.sqrt(Math.pow(topCenter.getX() - baseCenter.getX(), 2)
                + Math.pow(topCenter.getY() - baseCenter.getY(), 2)
                + Math.pow(topCenter.getZ() - baseCenter.getZ(), 2));

        double surfaceArea = 2 * Math.PI * radius * (radius + height);

        printArea(surfaceArea);
    }
}
