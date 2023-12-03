package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Circle extends Figure {
    private final ArrayList<Point> points;

    private Point center;

    private Point pointOnCircle;

    public Circle(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() == AMOUNT_OF_POINTS_TWO) {
            getPoints();
            return !(center.getX() == pointOnCircle.getX()
                    && center.getY() == pointOnCircle.getY()
                    && center.getZ() == pointOnCircle.getZ());
        }
        return false;
    }

    @Override
    public double calculateArea() {
        getPoints();
        double radius = calculateLength(center, pointOnCircle);
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        getPoints();
        double radius = calculateLength(center, pointOnCircle);
        return Math.PI * 2 * radius;
    }

    private void getPoints() {
        center = points.get(FIRST_POINT_INDEX);
        pointOnCircle = points.get(SECOND_POINT_INDEX);
    }
}
