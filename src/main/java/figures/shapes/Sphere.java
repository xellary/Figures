package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Sphere extends Figure {
    private final ArrayList<Point> points;
    private Point center;
    private Point pointOnSurface;
    public Sphere(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() != AMOUNT_OF_POINTS_TWO) {
            return false;
        }
        center = points.get(0);
        pointOnSurface = points.get(1);

        if (center.getX() == pointOnSurface.getX()
                && center.getY() == pointOnSurface.getY()
                && center.getZ() == pointOnSurface.getZ()) {
            return false;
        }

        double radiusSquared = Math.pow(pointOnSurface.getX() - center.getX(), 2)
                + Math.pow(pointOnSurface.getY() - center.getY(), 2)
                + Math.pow(pointOnSurface.getZ() - center.getZ(), 2);
        return !(radiusSquared <= 0);

    }

    @Override
    public void areaCalculation() {
        double radius = Math.sqrt(Math.pow(pointOnSurface.getX() - center.getX(), 2)
                + Math.pow(pointOnSurface.getY() - center.getY(), 2)
                + Math.pow(pointOnSurface.getZ() - center.getZ(), 2));

        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);

        printArea(surfaceArea);
    }
}
