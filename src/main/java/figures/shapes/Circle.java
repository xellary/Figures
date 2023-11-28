package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Circle extends Figure {
    private final ArrayList<Point> points;

    private Point p1;

    private Point p2;

    public Circle(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() == AMOUNT_OF_POINTS_TWO) {
            p1 = points.get(FIRST_POINT);
            p2 = points.get(SECOND_POINT);
            return !(p1.getX() == p2.getX() && p1.getY() == p2.getY() && p1.getZ() == p2.getZ());
        }
        return false;
    }

    @Override
    public void areaCalculation() {
        double radius = calculateLength(p1, p2);
        double area = Math.PI * Math.pow(radius, 2);
        printArea(area);
    }

    @Override
    public void perimeterCalculation() {
        double radius = calculateLength(p1, p2);
        double perimeter = Math.PI * 2 * radius;
        printPerimeter(perimeter);
    }
}
