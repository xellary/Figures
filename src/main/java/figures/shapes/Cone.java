package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Cone extends Figure {
    private final ArrayList<Point> points;

    private final Point center;

    private final Point pointOnCircle;

    private final Point apex;

    public Cone(ArrayList<Point> points) {
        this.points = points;
        center = points.get(FIRST_POINT_INDEX);
        pointOnCircle = points.get(SECOND_POINT_INDEX);
        apex = points.get(THIRD_POINT_INDEX);
    }

    @Override
    public boolean validateFigure() {
        if (points.size() != AMOUNT_OF_POINTS_THREE) {
            return false;
        }

        double radius = calculateLength(center, pointOnCircle);
        double height = calculateLength(center, apex);

        return radius > 0 && height > 0;
    }

    @Override
    public double calculateArea() {
        double radius = calculateLength(pointOnCircle, center);
        double height = calculateLength(apex, center);
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }
}
