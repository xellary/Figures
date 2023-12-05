package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Cone extends Figure {
    private final ArrayList<Point> points;

    private Point center;

    private Point pointOnCircle;

    private Point apex;

    public Cone(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() != AMOUNT_OF_POINTS_THREE) {
            return false;
        }
        getPoints();
        double radius = calculateLength(center, pointOnCircle);
        double height = calculateLength(center, apex);

        return radius > 0 && height > 0;
    }

    @Override
    public double calculateArea() {
        getPoints();
        double radius = calculateLength(pointOnCircle, center);
        double height = calculateLength(apex, center);
        double l = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
        return Math.PI * radius * (radius + l);
    }

    private void getPoints() {
        center = points.get(FIRST_POINT_INDEX);
        pointOnCircle = points.get(SECOND_POINT_INDEX);
        apex = points.get(THIRD_POINT_INDEX);
    }
}
