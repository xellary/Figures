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
        center = points.get(0);
        pointOnCircle = points.get(1);
        apex = points.get(2);

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
