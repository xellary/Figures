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
    public boolean validateFigure() {
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

        double radiusSquared = calculateLength(pointOnSurface, center);
        return !(radiusSquared <= 0);

    }

    @Override
    public double calculateArea() {
        double radius = calculateLength(pointOnSurface, center);
        return  4 * Math.PI * Math.pow(radius, 2);
    }
}
