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

        if (center.x == pointOnSurface.x && center.y == pointOnSurface.y && center.z == pointOnSurface.z) {
            return false;
        }

        double radiusSquared = Math.pow(pointOnSurface.x - center.x, 2)
                + Math.pow(pointOnSurface.y - center.y, 2)
                + Math.pow(pointOnSurface.z - center.z, 2);
        return !(radiusSquared <= 0);

    }

    @Override
    public void areaCalculation() {
        double radius = Math.sqrt(Math.pow(pointOnSurface.x - center.x, 2)
                + Math.pow(pointOnSurface.y - center.y, 2)
                + Math.pow(pointOnSurface.z - center.z, 2));

        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);

        printArea(surfaceArea);
    }
}
